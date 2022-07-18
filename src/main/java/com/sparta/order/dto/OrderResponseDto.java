package com.sparta.order.dto;

import com.sparta.order.model.Food;
import com.sparta.order.model.Order;
import com.sparta.order.model.OrderFoodItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private String restaurantName;

    private List<OrderFoodResponseDto> foods;

    private int deliveryFee;

    private int totalPrice;

    public void setOrderFoodResponseDtoList(List<Food> foodList, List<Integer> quantityList ) {
        OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto();
        for(int i =0; i<foodList.size(); i++){
            orderFoodResponseDto.setName(foodList.get(i).getName());
            orderFoodResponseDto.setQuantity(quantityList.get(i));
            orderFoodResponseDto.setPrice(foodList.get(i).getPrice());
            this.foods.add(orderFoodResponseDto);
        }
    }

    public  OrderResponseDto(Order order){
        this.restaurantName = order.getRestaurant().getName();
        this.deliveryFee = order.getDeliveryFee();
        this.totalPrice = order.getTotalPrice();
        List<OrderFoodResponseDto> orderFoodResponseDtoList = new ArrayList<>();
        List<OrderFoodItem> orderFoodItemList = order.getOrderFoodItemList();
        for (OrderFoodItem orderFoodItem : orderFoodItemList) {
            OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto();
            orderFoodResponseDto.setName(orderFoodItem.getName());
            orderFoodResponseDto.setQuantity(orderFoodItem.getQuantity());
            orderFoodResponseDto.setPrice(orderFoodItem.getPrice());
            orderFoodResponseDtoList.add(orderFoodResponseDto);
        }
        this.foods = orderFoodResponseDtoList;

    }

}
