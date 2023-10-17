package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.response.RestaurantDetailView;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();

//        return List.of(RestaurantView.builder()
//                .id(0L)
//                .name("test name")
//                .address("test address")
//                .createAt(ZonedDateTime.now())
//                .updateAt(ZonedDateTime.now())
//                .build());
    }


    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.getRestaurantDetail(restaurantId);

//        return RestaurantDetailView.builder()
//                .id(0L)
//                .name("test name")
//                .address("test address")
//                .createAt(ZonedDateTime.now())
//                .updateAt(ZonedDateTime.now())
//                .menus(List.of(
//                        RestaurantDetailView.Menu.builder()
//                                .id(0L)
//                                .name("test menu name")
//                                .price(500)
//                                .createAt(ZonedDateTime.now())
//                                .updateAt(ZonedDateTime.now())
//                                .build()
//                ))
//                .build();
    }


    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.createRestaurant(request);
    }


    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }


    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);
    }

}
