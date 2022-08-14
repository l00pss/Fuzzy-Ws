package com.food.ordering.system.order.service.application.rest;

import com.food.ordering.system.domain.message.MessageProvider;
import com.food.ordering.system.order.service.application.response.factory.AbstractResponseFactory;
import com.food.ordering.system.order.service.application.response.success.SuccessDataResponse;
import com.food.ordering.system.order.service.domain.dto.JResponse;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationService orderApplicationService;
    private final AbstractResponseFactory<JResponse> responseFactory;


    @PostMapping
    public ResponseEntity<SuccessDataResponse<JResponse>> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order for customer: {} at restaurant: {}", createOrderCommand.getCustomerId(),
                createOrderCommand.getRestaurantId());
        CreateOrderResponse createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
        log.info("Order created with tracking id: {}", createOrderResponse.getOrderTrackingId());
        return new ResponseEntity<>(this.responseFactory.factorySuccessDataResponse(createOrderResponse, MessageProvider.ok()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<SuccessDataResponse<JResponse>> getOrderByTrackingId(@PathVariable UUID trackingId) {
       TrackOrderResponse trackOrderResponse =
               orderApplicationService.trackOrder(TrackOrderQuery.builder().orderTrackingId(trackingId).build());
       log.info("Returning order status with tracking id: {}", trackOrderResponse.getOrderTrackingId());
       return  new ResponseEntity<>(this.responseFactory.factorySuccessDataResponse(trackOrderResponse,MessageProvider.ok()),HttpStatus.ACCEPTED);
    }
}
