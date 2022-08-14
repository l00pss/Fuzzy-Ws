package com.food.ordering.system.order.service.application.response.fail;

import com.food.ordering.system.order.service.application.response.Response;

public class FailResponse extends Response {
    public FailResponse() {
        super(false);
    }

    public FailResponse(String message) {
        super(false,message);
    }

    public FailResponse(String message,String redirect) {
        super(false,message,redirect);
    }
}
