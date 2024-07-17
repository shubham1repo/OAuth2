package com.example.ResourceServer.service;

import com.example.ResourceServer.dto.food_categorydto;

import com.example.ResourceServer.dto.food_itemdto;
import com.example.ResourceServer.mapper.food_categoryMapper;
import com.example.ResourceServer.model.food_category;
import com.example.ResourceServer.model.food_items;
import com.example.ResourceServer.repository.Repository;
import com.example.ResourceServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private Repository repository;

    @Autowired
    private UserRepository userRepository;



    public List<food_categorydto> getfoodCategory(){
        List<food_category> employees=repository.findAll();

        List<food_categorydto> employeeDtoList=employees.stream().map((food_categoryMapper::mapToEmployeeDto)).toList();
        return employeeDtoList;
    }

    public List<food_itemdto> getfoodItem(){
        List<food_items> employees=userRepository.findAll();

        List<food_itemdto> employeeDtoList=employees.stream().map((food_categoryMapper::mapTofoodItemDto)).toList();
        return employeeDtoList;
    }




}
