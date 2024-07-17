package com.example.ResourceServer.controller;

import com.example.ResourceServer.dto.food_categorydto;
import com.example.ResourceServer.dto.food_itemdto;
import com.example.ResourceServer.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {
    @Autowired
    private Service service;



    @GetMapping("/secret")
    public List<String> products() {
        return List.of("this","is","a","secret");
    }
    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome this is git";
    }

    @GetMapping("/get/food_category")
    public ResponseEntity<List<food_categorydto>> getById(){
        return new ResponseEntity<>(service.getfoodCategory(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/food_item")
    public ResponseEntity<List<food_itemdto>> getByItem(){
        return new ResponseEntity<>(service.getfoodItem(), HttpStatus.ACCEPTED);
    }

//    // @PreAuthorize("hasRole('USER')")
//    @GetMapping("/get")
//    public ResponseEntity<List<food_itemdto>> get() {
//        return new ResponseEntity<>(service.get(),HttpStatus.ACCEPTED);
//    }
//
//    @PostMapping("/post")
//    public ResponseEntity<food_itemdto> post(@RequestBody food_itemdto employeeDto){
//        return new ResponseEntity<>(service.post(employeeDto),HttpStatus.CREATED);
//    }
//
//    @PutMapping("/put/{id}")
//    public ResponseEntity<food_itemdto> put(@PathVariable("id") Long id, @RequestBody food_itemdto employeeDto){
//        return new ResponseEntity<>(service.update(id,employeeDto), HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable("id") Long id){
//        service.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
