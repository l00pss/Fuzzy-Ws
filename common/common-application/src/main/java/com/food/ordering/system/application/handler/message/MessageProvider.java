package com.food.ordering.system.application.handler.message;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageProvider {
    public static String fail(){
        return "Unexpected error!";
    }

    public static String ok(){
        return "";
    }

    //TODO
    public  String get(String code){
        if (checkCode(code)) return code;
        else return "___";
    }

    private  boolean checkCode(String code){
        return Objects.nonNull(code)  && code.contains("_") && code.length()==15;
    }

}
