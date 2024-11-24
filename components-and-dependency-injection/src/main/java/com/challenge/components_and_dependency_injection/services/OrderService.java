package com.challenge.components_and_dependency_injection.services;

import com.challenge.components_and_dependency_injection.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    /*public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }*/

    public double total(Order order) {
        double priceOrderWithDiscount = order.getBasic() * (1 - order.getDiscount());
        double priceShipping = shippingService.shipment(order);

        return priceOrderWithDiscount + priceShipping;
    }
}
