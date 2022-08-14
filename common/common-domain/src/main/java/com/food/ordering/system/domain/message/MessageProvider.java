package com.food.ordering.system.domain.message;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageProvider {
    public static String fail(){
        return "";
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
