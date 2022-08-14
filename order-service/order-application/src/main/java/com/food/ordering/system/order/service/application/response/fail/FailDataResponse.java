package com.food.ordering.system.order.service.application.response.fail;

import com.food.ordering.system.order.service.application.response.DataResponse;

public class FailDataResponse <D> extends DataResponse<D> {
    public FailDataResponse(D data, String message) {
        super(data, false, message);
    }

    public FailDataResponse(D data, String message, Exception exception) {
        super(data, false, message);
    }

    public FailDataResponse(D data){
        super(false,data);
    }

    public FailDataResponse(String message){
        super(null,false,message);
    }

    public FailDataResponse(String message,String redirect){super(null,false,message,redirect);}

    public FailDataResponse(){
        super(false,null);
    }
}