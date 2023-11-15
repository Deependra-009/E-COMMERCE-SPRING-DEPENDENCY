package com.ecommerce.services.WishList.ServiceImplementation;


import com.ecommerce.services.SuccessMessage;
import com.ecommerce.services.WishList.DTO.Response.FavouriteResponseDTO;
import com.ecommerce.services.WishList.Modals.FavouriteModal;
import com.ecommerce.services.WishList.Repository.FavouriteRepository;
import com.ecommerce.services.WishList.Service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FavouriteServiceImplementation implements FavouriteService {


    @Autowired
    private FavouriteRepository favouriteRepository;


    public FavouriteModal addProductInFavourite(String userId, String productId) {

        FavouriteModal favouriteModal =this.favouriteRepository.findFavouriteParticularUser(userId);
        List<String> favouriteProductData=null;
        if(favouriteModal ==null){
            favouriteProductData = new ArrayList<>();
            String favouriteId=UUID.randomUUID().toString();

            favouriteProductData.add(productId);

            favouriteModal = FavouriteModal.builder()
                    .favourite_id(favouriteId)
                    .user_id(userId)
                    .favouriteProductList(favouriteProductData)
                    .build();
        }
        else{
            favouriteProductData= favouriteModal.getFavouriteProductList();
            boolean isPresent=false;

            for(String product:favouriteProductData){
                if(product.equals(productId)){
                    isPresent=true;
                    break;
                }
            }
            if(!isPresent){
                favouriteProductData.add(productId);
            }

            favouriteModal.setFavouriteProductList(favouriteProductData);

        }
        FavouriteModal result= this.favouriteRepository.save(favouriteModal);
        return result;

    }

    @Override
    public SuccessMessage clearAllProductFromFavourite(String userId) {
        FavouriteModal favouriteModal =this.favouriteRepository.findFavouriteParticularUser(userId);
        if(favouriteModal!=null){
            this.favouriteRepository.delete(favouriteModal);
            SuccessMessage sm=new SuccessMessage("Favourite Cart Successfully",HttpStatus.OK);
            return sm;
        }
        SuccessMessage sm=new SuccessMessage("Favourite Already Clear Successfully",HttpStatus.OK);
        return sm;

    }

    @Override
    public SuccessMessage removeIndividualFromFavourite(String userId, String productId) {
        FavouriteModal favouriteModal =this.favouriteRepository.findFavouriteParticularUser(userId);

        if(favouriteModal==null){
            SuccessMessage sm=new SuccessMessage("Favourite Already Clear",HttpStatus.OK);

            return sm;
        }

        List<String> favouriteList= favouriteModal.getFavouriteProductList();

        List<String> updateList=favouriteList
                .stream()
                .filter((e)->!e.equals(productId))
                .toList();

        if(updateList.isEmpty()){
            this.favouriteRepository.delete(favouriteModal);
        }
        else{
            favouriteModal.setFavouriteProductList(updateList);
            this.favouriteRepository.save(favouriteModal);
        }
        SuccessMessage sm=new SuccessMessage("Remove Product From Favourite Successfully",HttpStatus.OK);

        return sm;
    }

    @Override
    public FavouriteResponseDTO getFavouriteData(String userId) {
        FavouriteModal favouriteModal =this.favouriteRepository.findFavouriteParticularUser(userId);
        FavouriteResponseDTO favouriteResponseDTO = FavouriteResponseDTO.builder()
                .userId(userId)
                .favouriteProductList(favouriteModal.getFavouriteProductList())
                .build();

        return favouriteResponseDTO;

    }
}
