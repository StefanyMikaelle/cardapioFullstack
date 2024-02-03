package com.stefanyEngenheiraDev.cardapioFullstack.domain.food.dtos;

import com.stefanyEngenheiraDev.cardapioFullstack.domain.food.entity.Food;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(),food.getImage(),food.getPrice());
    }
}
