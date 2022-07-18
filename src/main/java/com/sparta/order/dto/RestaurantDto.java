package com.sparta.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
