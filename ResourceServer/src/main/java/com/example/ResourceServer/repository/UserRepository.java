package com.example.ResourceServer.repository;

import com.example.ResourceServer.model.food_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<food_items, Long> {
}
