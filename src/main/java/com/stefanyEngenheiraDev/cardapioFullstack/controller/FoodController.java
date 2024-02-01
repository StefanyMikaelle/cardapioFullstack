package com.stefanyEngenheiraDev.cardapioFullstack.controller;

import com.stefanyEngenheiraDev.cardapioFullstack.dtos.FoodRequestDto;
import com.stefanyEngenheiraDev.cardapioFullstack.dtos.FoodResponseDto;
import com.stefanyEngenheiraDev.cardapioFullstack.entity.Food;
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
    public void saveFood(@RequestBody FoodRequestDto foodRequestDto){
        Food foodData = new Food(foodRequestDto);
        foodRepository.save(foodData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDto> getAll(){
        List<FoodResponseDto> foodList = foodRepository.findAll().stream().map(FoodResponseDto::new).toList();
        return foodList;
    }
}
