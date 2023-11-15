package com.ecommerce.services.WishList.Service;


import com.ecommerce.services.SuccessMessage;
import com.ecommerce.services.WishList.DTO.Response.FavouriteResponseDTO;
import com.ecommerce.services.WishList.Modals.FavouriteModal;
import org.springframework.http.ResponseEntity;

public interface FavouriteService {


    public FavouriteModal addProductInFavourite(String userId, String productId);


    public SuccessMessage clearAllProductFromFavourite(String userId);

    public SuccessMessage removeIndividualFromFavourite(String userId, String productId);

    public FavouriteResponseDTO getFavouriteData(String userId);

}
