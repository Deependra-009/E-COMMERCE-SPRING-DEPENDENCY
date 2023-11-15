package com.ecommerce.services.Cart.Modals;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "cart_collection")
public class CartModal {

    @Id
    private String cart_id;
    private String user_id;
    private List<CartProductModal> cartProductModalList;

}
