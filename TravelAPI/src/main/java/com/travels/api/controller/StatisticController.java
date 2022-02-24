package com.travels.api.controller;
import java.util.List;

import com.travels.api.model.Statistic;
import com.travels.api.model.Travel;
import com.travels.api.service.StatisticService;
import com.travels.api.service.TravelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api-travels/statistics")
public class StatisticController {

    private static final Logger logger = Logger.getLogger(StatisticController.class);

    @Autowired
    private TravelService tripsService;

    @Autowired
    private StatisticService statisticsService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<Statistic> getStatistics() {

        List<Travel> trips  = tripsService.find();
        Statistic statistics = statisticsService.create(trips);

        logger.info(statistics);

        return ResponseEntity.ok(statistics);
    }
}