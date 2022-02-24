package com.travels.api.factory;

import com.travels.api.model.Travel;

public interface TravelFactory {

    Travel createTravel (String type);
}
