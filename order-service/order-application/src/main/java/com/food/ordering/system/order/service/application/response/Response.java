package com.food.ordering.system.order.service.application.response;

import java.time.LocalDateTime;

public abstract class Response {
    private final boolean success;

    private String message;

    private LocalDateTime time;

    /**
     * @field Redirect Link for Response
     */
    private String redirect;

    public Response(boolean success) {
        this.success = success;
        this.time = LocalDateTime.now();
    }

    public Response(boolean success, String message) {
        this(success);
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public Response(boolean success, String message,String redirect) {
        this(success,message);
        this.redirect = redirect;
    }

    public Response(boolean success, String message, LocalDateTime localDateTime) {
        this(success,message);
        this.time =localDateTime;
    }

    public Response(boolean success, String message, LocalDateTime localDateTime,String redirect) {
        this(success,message,localDateTime);
        this.redirect =redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public String getRedirect() {
        return redirect;
    }
}
