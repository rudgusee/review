package com.jyujyu.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantView {

    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createAt;
    private ZonedDateTime updateAt;

}
