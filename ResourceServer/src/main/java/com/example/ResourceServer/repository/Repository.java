package com.example.ResourceServer.repository;

import com.example.ResourceServer.model.food_category;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<food_category,Long> {
}
