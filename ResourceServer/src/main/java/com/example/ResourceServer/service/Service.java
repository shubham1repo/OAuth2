package com.example.ResourceServer.service;

import com.example.ResourceServer.dto.food_categorydto;
import com.example.ResourceServer.dto.food_itemdto;

import java.util.List;

public interface Service {
    public List<food_categorydto> getfoodCategory();
    public List<food_itemdto> getfoodItem();
}
