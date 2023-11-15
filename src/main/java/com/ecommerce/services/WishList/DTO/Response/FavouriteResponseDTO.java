package com.ecommerce.services.WishList.DTO.Response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FavouriteResponseDTO {

    private String userId;
    private List<String>  favouriteProductList;
}
