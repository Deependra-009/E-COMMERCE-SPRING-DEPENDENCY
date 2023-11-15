package com.ecommerce.services.Cart.Modals;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartProductModal {

    private String productId;
    private String quantity;

}
