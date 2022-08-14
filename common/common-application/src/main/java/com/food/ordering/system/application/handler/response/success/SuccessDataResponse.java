package com.food.ordering.system.application.handler.response.success;

import com.food.ordering.system.application.handler.response.DataResponse;

public class SuccessDataResponse <D> extends DataResponse<D> {


    public SuccessDataResponse(D data, String message) {
        super(data, true, message);
    }

    public SuccessDataResponse(D data, String message, String redirect) {
        super(data, true, message,redirect);
    }

    public SuccessDataResponse(D data){
        super(true,data);
    }

    public SuccessDataResponse(String message){
        super(null,true,message);
    }

    public SuccessDataResponse(){
        super(true,null);
    }

}