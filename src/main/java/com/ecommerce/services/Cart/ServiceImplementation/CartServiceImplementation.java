package com.ecommerce.services.Cart.ServiceImplementation;


import com.ecommerce.services.Cart.Modals.CartModal;
import com.ecommerce.services.Cart.Modals.CartProductModal;
import com.ecommerce.services.Cart.Repository.CartRepository;
import com.ecommerce.services.Cart.Service.CartService;
import com.ecommerce.services.Cart.DTO.Response.CartResponseDTO;
import com.ecommerce.services.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImplementation implements CartService {


    @Autowired
    private CartRepository cartRepository;


    public CartModal addProductInCart(String userId, String productId, String quantity) {

        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        List<CartProductModal> cartProductData=null;
        if(cartModal==null){
            cartProductData = new ArrayList<>();
            String cartId=UUID.randomUUID().toString();

            CartProductModal cartProductModal = CartProductModal.builder()
                    .productId(productId)
                    .quantity(quantity)
                    .build();
            cartProductData.add(cartProductModal);

            cartModal=CartModal.builder()
                    .cart_id(cartId)
                    .user_id(userId)
                    .cartProductModalList(cartProductData)
                    .build();
        }
        else{
            cartProductData=cartModal.getCartProductModalList();
            boolean isPresent=false;

            for(CartProductModal product:cartProductData){
                if(product.getProductId().equals(productId)){
                    isPresent=true;
                    break;
                }
            }
            if(!isPresent){
                CartProductModal cartProductModal=CartProductModal.builder()
                        .productId(productId)
                        .quantity(quantity)
                        .build();
                cartProductData.add(cartProductModal);
            }

            cartModal.setCartProductModalList(cartProductData);

        }
        CartModal result= this.cartRepository.save(cartModal);
        return result;

    }

    @Override
    public SuccessMessage increaseProductQuantityInCartByOne(String userId, String productId) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        List<CartProductModal> cartList=cartModal.getCartProductModalList();
        for(int i=0;i<cartList.size();i++){

            CartProductModal cartProductModal=cartList.get(i);

            if(cartProductModal.getProductId().equals(productId)){
                int quantity=Integer.parseInt(cartProductModal.getQuantity())+1;
                cartProductModal.setQuantity(""+quantity);
                cartList.set(i,cartProductModal);
                cartModal.setCartProductModalList(cartList);
                break;
            }

        }

        this.cartRepository.save(cartModal);

        SuccessMessage sm=new SuccessMessage("Increase Quantity Successfully",HttpStatus.OK);

        return sm;

    }

    @Override
    public SuccessMessage decreaseProductQuantityInCartByOne(String userId, String productId) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        List<CartProductModal> cartList=cartModal.getCartProductModalList();
        for(int i=0;i<cartList.size();i++){

            CartProductModal cartProductModal=cartList.get(i);

            if(cartProductModal.getProductId().equals(productId)){
                int quantity=Integer.parseInt(cartProductModal.getQuantity())-1;
                if(quantity==0){
                    cartList.remove(i);
                    break;
                }
                cartProductModal.setQuantity(""+quantity);
                cartList.set(i,cartProductModal);
                cartModal.setCartProductModalList(cartList);
                break;
            }

        }
        this.cartRepository.save(cartModal);

        SuccessMessage sm=new SuccessMessage("Decrease Quantity Successfully",HttpStatus.OK);

        return sm;
    }

    @Override
    public SuccessMessage setProductQuantityInCartByNumber(String userId, String productId, String quantity) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        List<CartProductModal> cartList=cartModal.getCartProductModalList();
        for(int i=0;i<cartList.size();i++){

            CartProductModal cartProductModal=cartList.get(i);

            if(cartProductModal.getProductId().equals(productId)){
                cartProductModal.setQuantity(quantity);
                cartList.set(i,cartProductModal);
                cartModal.setCartProductModalList(cartList);
                break;
            }

        }
        this.cartRepository.save(cartModal);

        SuccessMessage sm=new SuccessMessage("Set Quantity Successfully",HttpStatus.OK);

        return sm;
    }

    @Override
    public SuccessMessage clearAllProductFromCart(String userId) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        if(cartModal!=null){
            this.cartRepository.delete(cartModal);
            SuccessMessage sm=new SuccessMessage("Clear Cart Successfully",HttpStatus.OK);
            return sm;
        }
        SuccessMessage sm=new SuccessMessage("Cart Already Clear Successfully",HttpStatus.ALREADY_REPORTED);
        return sm;

    }



    @Override
    public SuccessMessage removeIndividualFromCart(String userId, String productId) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);

        if(cartModal==null){
            SuccessMessage sm=new SuccessMessage("Cart Already Clear",HttpStatus.OK);

            return sm;
        }

        List<CartProductModal> cartList=cartModal.getCartProductModalList();

        List<CartProductModal> updateList=cartList
                .stream()
                .filter((e)->!e.getProductId().equals(productId))
                .toList();

        if(updateList.isEmpty()){
            this.cartRepository.delete(cartModal);
        }
        else{
            cartModal.setCartProductModalList(updateList);
            this.cartRepository.save(cartModal);
        }
        SuccessMessage sm=new SuccessMessage("Remove Product From Cart Successfully",HttpStatus.OK);

        return sm;
    }

    @Override
    public CartResponseDTO getCartData(String userId) {
        CartModal cartModal=this.cartRepository.findCartParicularUser(userId);
        CartResponseDTO cartResponseDTO=CartResponseDTO.builder()
                .userId(userId)
                .cartProductModalList(cartModal.getCartProductModalList())
                .build();

        return cartResponseDTO;

    }
}
