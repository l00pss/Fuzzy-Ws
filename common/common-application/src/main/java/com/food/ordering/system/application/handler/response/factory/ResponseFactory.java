package com.food.ordering.system.application.handler.response.factory;

import com.food.ordering.system.application.handler.response.fail.FailDataResponse;
import com.food.ordering.system.application.handler.response.fail.FailResponse;
import com.food.ordering.system.application.handler.response.success.SuccessDataResponse;
import com.food.ordering.system.application.handler.response.success.SuccessResponse;
import org.springframework.stereotype.Component;

@Component
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
