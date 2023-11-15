package com.ecommerce.services.Cart.DTO.Response;

import com.ecommerce.services.Cart.Modals.CartModal;
import com.ecommerce.services.Cart.Modals.CartProductModal;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CartResponseDTO {

    private String userId;
    private List<CartProductModal>  cartProductModalList;
}
