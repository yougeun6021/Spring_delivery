package com.sparta.order.controller;

import com.sparta.order.dto.FoodRequestDto;
import com.sparta.order.dto.RestaurantDto;
import com.sparta.order.model.Food;
import com.sparta.order.model.Restaurant;
import com.sparta.order.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantService.getAllRestaurant();

    }

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registerRestaurant(restaurantDto);

    }



}
