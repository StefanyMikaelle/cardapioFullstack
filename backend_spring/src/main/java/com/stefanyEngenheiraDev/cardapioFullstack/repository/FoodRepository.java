package com.stefanyEngenheiraDev.cardapioFullstack.repository;

import com.stefanyEngenheiraDev.cardapioFullstack.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
