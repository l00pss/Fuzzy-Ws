package com.food.ordering.system.application.handler.response.factory;

import com.food.ordering.system.application.handler.response.fail.FailDataResponse;
import com.food.ordering.system.application.handler.response.fail.FailResponse;
import com.food.ordering.system.application.handler.response.success.SuccessDataResponse;
import com.food.ordering.system.application.handler.response.success.SuccessResponse;

public  interface AbstractResponseFactory <D>{
    SuccessResponse factorySuccessResponse(String message);

    FailResponse factoryFailResponse(String message);


    SuccessDataResponse<D> factorySuccessDataResponse(D data, String message);

    FailDataResponse<D> factoryFailDataResponse(String message);

    FailDataResponse<D> factoryFailDataResponse(D data, String message);
}
