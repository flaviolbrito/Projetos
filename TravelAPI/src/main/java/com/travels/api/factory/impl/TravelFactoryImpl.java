package com.travels.api.factory.impl;


import com.travels.api.enumeration.TravelTypeEnum;
import com.travels.api.factory.TravelFactory;
import com.travels.api.model.Travel;

public class TravelFactoryImpl implements TravelFactory {

    @Override
    public Travel createTravel (String type) {

        if (TravelTypeEnum.ONE_WAY.getValue().equals(type)) {
            return new Travel(TravelTypeEnum.ONE_WAY);
        } else if (TravelTypeEnum.MULTI_CITY.getValue().equals(type)) {
            return new Travel(TravelTypeEnum.MULTI_CITY);
        }

        return new Travel(TravelTypeEnum.RETURN);
    }

}
