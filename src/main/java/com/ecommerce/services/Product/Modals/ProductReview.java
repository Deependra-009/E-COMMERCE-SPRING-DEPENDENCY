package com.ecommerce.services.Product.Modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductReview {

    private String user_name;
    private String rating;
    private String title;
    private String body;
    private String date;



}

