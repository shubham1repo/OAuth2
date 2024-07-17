package com.example.ResourceServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class food_itemdto {
    private Long id;
    private String category_name;
    private String name;
    private String img;
    private String description;
}
