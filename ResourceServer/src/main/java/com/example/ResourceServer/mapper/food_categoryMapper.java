package com.example.ResourceServer.mapper;

import com.example.ResourceServer.dto.food_categorydto;
import com.example.ResourceServer.dto.food_itemdto;
import com.example.ResourceServer.model.food_category;
import com.example.ResourceServer.model.food_items;

public interface food_categoryMapper {
    public static food_categorydto mapToEmployeeDto(food_category employee){
        return new food_categorydto(employee.getId(),employee.getCategory_name());
    }

    public static food_category mapToEmployee(food_categorydto employeeDto){
        return new food_category(employeeDto.getId(),employeeDto.getCategory_name());
    }

    public static food_itemdto mapTofoodItemDto(food_items employee){
        return new food_itemdto(employee.getId(),employee.getCategory_name(),employee.getName(),employee.getImg(),employee.getDescription());
    }
}
