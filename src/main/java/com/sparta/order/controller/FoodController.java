package com.sparta.order.controller;

import com.sparta.order.dto.FoodRequestDto;
import com.sparta.order.model.Food;
import com.sparta.order.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void  registerFoods(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> foodRequestDtoList){
        foodService.addFoodList(restaurantId,foodRequestDtoList);

    }
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFoods(@PathVariable Long restaurantId){

        return foodService.getAllRestaurantFoodList(restaurantId);
    }
}
