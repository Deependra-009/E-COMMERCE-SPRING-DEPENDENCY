package com.ecommerce.services.Cart.Service;


import com.ecommerce.services.Cart.Modals.CartModal;
import com.ecommerce.services.Cart.DTO.Response.CartResponseDTO;
import com.ecommerce.services.SuccessMessage;
import org.springframework.http.ResponseEntity;

public interface CartService {


    public CartModal addProductInCart(String userId, String productId, String quantity);

    public SuccessMessage increaseProductQuantityInCartByOne(String userId, String productId);

    public SuccessMessage decreaseProductQuantityInCartByOne(String userId,String productId);

    public SuccessMessage setProductQuantityInCartByNumber(String userId, String productId, String quantity);

    public SuccessMessage clearAllProductFromCart(String userId);

    public SuccessMessage removeIndividualFromCart(String userId,String productId);

    public CartResponseDTO getCartData(String userId);

}
