package com.travels.api.controller;
import com.travels.api.model.Travel;
import com.travels.api.service.TravelService;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api-travels/travels")
public class TravelController {

    private static final Logger logger = Logger.getLogger(TravelController.class);

    @Autowired
    private TravelService tripService;

    @GetMapping
    public ResponseEntity<List<Travel>> find() {
        if(tripService.find().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        logger.info(tripService.find());
        return ResponseEntity.ok(tripService.find());
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete() {
        try {
            tripService.delete();
            return ResponseEntity.noContent().build();
        }catch(Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Travel> create(@RequestBody JSONObject trip) {
        try {
            if(tripService.isJSONValid(trip.toString())) {
                Travel travelCreated = tripService.create(trip);
                var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(travelCreated.getOrderNumber()).build().toUri();

                if(tripService.isStartDateGreaterThanEndDate(travelCreated)){
                    logger.error("The start date is greater than end date.");
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
                }else {
                    tripService.add(travelCreated);
                    return ResponseEntity.created(uri).body(null);
                }
            }else {
                return ResponseEntity.badRequest().body(null);
            }
        }catch(Exception e) {
            logger.error("JSON fields are not parsable. " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @PutMapping(path = "/{id}", produces = { "application/json" })
    public ResponseEntity<Travel> update(@PathVariable("id") long id, @RequestBody JSONObject travel) {
        try {
            if(tripService.isJSONValid(travel.toString())) {
                Travel tripToUpdate = tripService.findById(id);
                if(tripToUpdate == null){
                    logger.error("Travel not found.");
                    return ResponseEntity.notFound().build();
                }else {
                    Travel tripUpdated = tripService.update(tripToUpdate, travel);
                    return ResponseEntity.ok(tripUpdated);
                }
            }else {
                return ResponseEntity.badRequest().body(null);
            }
        }catch(Exception e) {
            logger.error("JSON fields are not parsable." + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
}