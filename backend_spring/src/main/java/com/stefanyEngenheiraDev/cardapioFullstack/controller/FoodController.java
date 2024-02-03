package com.stefanyEngenheiraDev.cardapioFullstack.controller;

import com.stefanyEngenheiraDev.cardapioFullstack.domain.food.dtos.FoodRequestDTO;
import com.stefanyEngenheiraDev.cardapioFullstack.domain.food.dtos.FoodResponseDTO;
import com.stefanyEngenheiraDev.cardapioFullstack.domain.food.entity.Food;
import com.stefanyEngenheiraDev.cardapioFullstack.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO foodRequestDto){
        Food foodData = new Food(foodRequestDto);
        foodRepository.save(foodData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
