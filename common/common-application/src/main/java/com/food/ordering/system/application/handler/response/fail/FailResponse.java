package com.food.ordering.system.application.handler.response.fail;

import com.food.ordering.system.application.handler.response.Response;

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
