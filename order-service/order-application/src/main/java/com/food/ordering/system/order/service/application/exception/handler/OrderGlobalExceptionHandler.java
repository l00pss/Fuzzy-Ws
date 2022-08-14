package com.food.ordering.system.order.service.application.exception.handler;

import com.food.ordering.system.application.handler.GlobalExceptionHandler;
import com.food.ordering.system.application.handler.message.MessageProvider;
import com.food.ordering.system.application.handler.response.factory.AbstractResponseFactory;
import com.food.ordering.system.application.handler.response.fail.FailDataResponse;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

    private final AbstractResponseFactory<?> responseFactory;
    private final MessageProvider messageProvider;

    @ResponseBody
    @ExceptionHandler(value = {OrderDomainException.class})
    public ResponseEntity<FailDataResponse<?>> handleException(OrderDomainException orderDomainException) {
        log.error(orderDomainException.getMessage(), orderDomainException);
        return new ResponseEntity<>(this.responseFactory
                .factoryFailDataResponse(this.messageProvider.get(orderDomainException.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(value = {OrderNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<FailDataResponse<?>> handleException(OrderNotFoundException orderNotFoundException) {
        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
        return new ResponseEntity<>(this.responseFactory
                .factoryFailDataResponse(this.messageProvider.get(orderNotFoundException.getMessage())),
                HttpStatus.BAD_REQUEST);
    }
}
