package com.food.ordering.system.order.service.domain.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String code) {
        super(code);
    }

    public OrderDomainException(String code, Throwable cause) {
        super(code, cause);
    }
}
