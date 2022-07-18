package com.sparta.order.service;

import com.sparta.order.dto.FoodRequestDto;
import com.sparta.order.model.Food;
import com.sparta.order.model.Restaurant;
import com.sparta.order.repository.FoodRepository;
import com.sparta.order.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    private final RestaurantRepository restaurantRepository;


    public void addFoodList(Long restaurantId, List<FoodRequestDto> foodRequestDtoList) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new NullPointerException("레스트랑이 존재하지 않습니다")
        );
        List<Food>existFoodList = foodRepository.findAllByRestaurant(restaurant);
        List<String>foodNameList = new ArrayList<>();

        List<Food> foodList = new ArrayList<>();
        for (FoodRequestDto foodRequestDto : foodRequestDtoList) {
            if(foodNameList.contains(foodRequestDto.getName())){
                throw new IllegalArgumentException("입력한 메뉴에서 중복된 메뉴가 존재합니다");
            }
            foodNameList.add(foodRequestDto.getName());
            Food food = new Food(foodRequestDto,restaurant);
            int price = food.getPrice();
            if(price<100 || price>1000000|| price%100 !=0){
                throw new IllegalArgumentException("잘못된 가격입니다.");
            }
            if(isExistFoodName(food,existFoodList)){
                throw new IllegalArgumentException("현재 메뉴와 중복된 메뉴가 존재합니다");
            }
            foodList.add(food);

        }
        foodRepository.saveAll(foodList);



    }

    public List<Food> getAllRestaurantFoodList(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new NullPointerException("레스트랑이 존재하지 않습니다")
        );

        return foodRepository.findAllByRestaurant(restaurant);
    }

    private boolean isExistFoodName(Food food, List<Food> existFoodList){
        for(int i =0; i<existFoodList.size(); i++){
            if(food.getName().equals(existFoodList.get(i).getName())){
                return true;
            }
        }
        return false;


    }
}


