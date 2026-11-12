package com.korai.study03.domain.restaurant.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RestaurantCreateRequest {
    private String name;
    private String category;
    private String district;
    private String address;
    private String phone;
    private int minOrderAmount;
    private int deliveryFee;
    private String openTime;
    private String closeTime;
    private LocalDate openedAt;
    private boolean opened;
}
