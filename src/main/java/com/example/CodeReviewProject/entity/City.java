package com.example.CodeReviewProject.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {

    private String cityName;
    private String zipCode;
}
