package com.sparta.order.service;

import com.sparta.order.dto.RestaurantDto;
import com.sparta.order.model.Restaurant;
import com.sparta.order.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;



    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant registerRestaurant(RestaurantDto restaurantDto) {
        int minOrderPrice = restaurantDto.getMinOrderPrice();
        if(minOrderPrice<1000 || minOrderPrice >100000 || minOrderPrice%100 !=0){
            throw  new IllegalArgumentException("잘못된 최소 주문가격입니다");
        }
        int deliveryFee = restaurantDto.getDeliveryFee();
        if(0>deliveryFee || deliveryFee>10000 || deliveryFee%500!=0){
            throw new IllegalArgumentException("잘못된 기본 배달비입니다");
        }
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);

        return restaurant;

    }


}
