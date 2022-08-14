package com.food.ordering.system.application.handler;

import com.food.ordering.system.application.handler.message.MessageProvider;
import com.food.ordering.system.application.handler.response.factory.AbstractResponseFactory;
import com.food.ordering.system.application.handler.response.fail.FailDataResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
@Getter
public class GlobalExceptionHandler {

    private final MessageProvider messageProvider;
    private final AbstractResponseFactory<?> responseFactory;

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<FailDataResponse<?>> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(this.responseFactory.factoryFailDataResponse(MessageProvider.fail()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<FailDataResponse<?>> handleException(ValidationException validationException) {
       FailDataResponse<?> failDataResponse;
       if (validationException instanceof ConstraintViolationException) {
           String violations = extractViolationsFromException((ConstraintViolationException) validationException);
           log.error(violations, validationException);
           failDataResponse = this.responseFactory.factoryFailDataResponse(violations);
       } else {
           String exceptionMessage = validationException.getMessage();
           log.error(exceptionMessage, validationException);
           failDataResponse = this.responseFactory.factoryFailDataResponse(exceptionMessage);
       }
       return new ResponseEntity<>(failDataResponse,HttpStatus.BAD_REQUEST);
    }

    private String extractViolationsFromException(ConstraintViolationException validationException) {
        return validationException.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("--"));
    }

}
