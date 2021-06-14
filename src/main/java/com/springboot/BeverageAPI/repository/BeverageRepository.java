package com.springboot.BeverageAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.BeverageAPI.entities.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {

}


