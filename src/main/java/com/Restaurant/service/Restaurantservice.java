package com.Restaurant.service;

import com.Restaurant.Model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Restaurantservice {
    private static List<Restaurant> restaurant = new ArrayList<>();
    private static int  count =0;
    static {

        restaurant.add(new Restaurant(++count,"Hotel1","Delhi","9748658517","Food Type1",10));
        restaurant.add(new Restaurant(++ count,"Hotel2","Kolkata","9748658518","Food Type2",20));
        restaurant.add(new Restaurant(++count,"Hotel3","patna","9748658519" ,"Food Type3",30));
        restaurant.add(new Restaurant(++count,"Hotel4","Mumbai","9748658510","Food Type4",40));
        restaurant.add(new Restaurant(++count,"Hotel5","Hydrabad","9748658511","Food Type5",50));
    }
    public List<Restaurant> finaAll() {
        return restaurant;
    }

    public Restaurant findById(int id) {
        Restaurant res=restaurant.get(id);

        return res;
    }

    public void addHotel(Restaurant hotelDetails) {
        restaurant.add(hotelDetails);

    }

    public void deleteById(int RestaurantId) {
        restaurant.remove(RestaurantId);

    }

    public void updateById(int restaurantId, Restaurant restaurant1) {

        Restaurant restaurantUpdate=findById(restaurantId);

        restaurantUpdate.setRestaurantName(restaurant1.getRestaurantName());
        restaurantUpdate.setRestaurantAddress(restaurant1.getRestaurantAddress());
        restaurantUpdate.setRestaurantNumber(restaurant1.getRestaurantNumber());
        restaurantUpdate.setSpecialty(restaurant1.getSpecialty());
        restaurantUpdate.setTotalStaff(restaurant1.getTotalStaff());
    }
}
