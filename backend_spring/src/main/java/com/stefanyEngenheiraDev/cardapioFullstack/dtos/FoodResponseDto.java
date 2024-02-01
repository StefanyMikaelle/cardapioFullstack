package com.stefanyEngenheiraDev.cardapioFullstack.dtos;

import com.stefanyEngenheiraDev.cardapioFullstack.entity.Food;

public record FoodResponseDto(Long id, String title, String image, Integer price) {
    public FoodResponseDto(Food food){
        this(food.getId(), food.getTitle(),food.getImage(),food.getPrice());
    }
}
