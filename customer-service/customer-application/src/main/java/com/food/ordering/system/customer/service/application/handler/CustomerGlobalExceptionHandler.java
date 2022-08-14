package com.food.ordering.system.customer.service.application.handler;

import com.food.ordering.system.application.handler.GlobalExceptionHandler;
import com.food.ordering.system.application.handler.message.MessageProvider;
import com.food.ordering.system.application.handler.response.factory.AbstractResponseFactory;
import com.food.ordering.system.application.handler.response.fail.FailDataResponse;
import com.food.ordering.system.customer.service.domain.exception.CustomerDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class CustomerGlobalExceptionHandler extends GlobalExceptionHandler {


    @Autowired
    public CustomerGlobalExceptionHandler(MessageProvider messageProvider, AbstractResponseFactory<?> responseFactory) {
        super(messageProvider, responseFactory);
    }

    @ResponseBody
    @ExceptionHandler(value = {CustomerDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<FailDataResponse<?>> handleException(CustomerDomainException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(super.getResponseFactory()
                .factoryFailDataResponse(
                        super.getMessageProvider()
                        .get(exception.getMessage())
                ),
                HttpStatus.BAD_REQUEST);
    }

}
