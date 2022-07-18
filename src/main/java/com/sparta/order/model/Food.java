package com.sparta.order.model;

import com.sparta.order.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Setter
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID" , nullable = false)
    private Restaurant restaurant;

    public Food(FoodRequestDto foodRequestDto, Restaurant restaurant){
        this.name= foodRequestDto.getName();
        this.price =foodRequestDto.getPrice();
        this.restaurant = restaurant;
    }



}
