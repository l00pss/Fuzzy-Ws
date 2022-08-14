package com.food.ordering.system.order.service.application.response.success;

import com.food.ordering.system.order.service.application.response.Response;

public class SuccessResponse extends Response {
    public SuccessResponse() {
        super(true);
    }

    public SuccessResponse(String message) {
        super(true,message);
    }

    public SuccessResponse(String message,String redirect) {
        super(true,message,redirect);
    }


}