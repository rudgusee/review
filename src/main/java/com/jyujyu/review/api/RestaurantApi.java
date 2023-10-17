package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is getRestaurants";
    }


    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is getRestaurants, " + restaurantId;
    }


    @PostMapping("/restaurant")
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is createRestaurant, name = " + request.getName()
                + " address = " + request.getAddress()
                + " menus[0].name = " + request.getMenus().get(0).getName()
                + " menus[0].price = " + request.getMenus().get(0).getPrice();
    }


    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is editRestaurant, name = " + request.getName()
                + " address = " + request.getAddress()
                + " menus[0].name = " + request.getMenus().get(0).getName()
                + " menus[0].price = " + request.getMenus().get(0).getPrice();
    }


    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is getRestaurants, " + restaurantId;
    }

}
