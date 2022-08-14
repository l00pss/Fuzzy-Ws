package com.food.ordering.system.order.service.application.response.factory;

import com.food.ordering.system.order.service.application.response.fail.FailDataResponse;
import com.food.ordering.system.order.service.application.response.fail.FailResponse;
import com.food.ordering.system.order.service.application.response.success.SuccessDataResponse;
import com.food.ordering.system.order.service.application.response.success.SuccessResponse;

public class ResponseFactory<D> implements AbstractResponseFactory<D>{
    @Override
    public SuccessResponse factorySuccessResponse(String message) {
        return new SuccessResponse(message);
    }

    @Override
    public FailResponse factoryFailResponse(String message) {
        return new FailResponse(message);
    }

    @Override
    public SuccessDataResponse<D> factorySuccessDataResponse(D data, String message) {
        return new SuccessDataResponse<D>(data,message);
    }

    @Override
    public FailDataResponse<D> factoryFailDataResponse(String message) {
        return new FailDataResponse<D>(message);
    }

    @Override
    public FailDataResponse<D> factoryFailDataResponse(D data, String message) {
        return new FailDataResponse<D>(data,message);
    }

}
