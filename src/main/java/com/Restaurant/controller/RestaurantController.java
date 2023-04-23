package com.Restaurant.controller;

import com.Restaurant.Model.Restaurant;
import com.Restaurant.service.Restaurantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestaurantController {
    @Autowired
    private Restaurantservice restaurantservice;
    @GetMapping("getall")
    public List<Restaurant> findall(){
        return restaurantservice.finaAll();
    }
    @GetMapping("/getById/{ID}")
    public Restaurant getbyid(@PathVariable int ID)
    {
        return  restaurantservice.findById(ID);
    }
    @PostMapping("addrestaurant")
    public void addRestaurant (@RequestBody Restaurant restaurant) {
          restaurantservice.addHotel(restaurant);
    }
    @PostMapping("update/{Id}")
    public  void  updateById(@PathVariable int Id,@RequestBody Restaurant restaurant)
    {
        restaurantservice.updateById(Id,restaurant);
    }

    @DeleteMapping("deletebyid/{Id}")
    public  void  deletebyid(@PathVariable int Id){
        restaurantservice.deleteById(Id);
    }

}
