package com.food.ordering.system.order.service.application.response;

public abstract class DataResponse<D> extends Response {
    private final D data;


    public DataResponse(D data, boolean success, String message) {
        super(success, message);
        this.data=data;
    }

    public DataResponse(D data, boolean success, String message,String redirect) {
        this(data,success, message);
        super.setRedirect(redirect);
    }

    public DataResponse(boolean success, D data) {
        super(success);
        this.data = data;
    }

    public DataResponse(boolean success) {
        super(success);
        this.data = null;
    }
}
