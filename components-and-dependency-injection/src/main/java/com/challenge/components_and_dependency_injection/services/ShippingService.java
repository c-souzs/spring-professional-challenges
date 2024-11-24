package com.challenge.components_and_dependency_injection.services;

import com.challenge.components_and_dependency_injection.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order) {
        double priceOrderNoDiscount = order.getBasic();

        if(priceOrderNoDiscount < 100.00) return 20.00;
        else if (priceOrderNoDiscount < 200.00) return 12.00;

        return 0.0;
    }
}
