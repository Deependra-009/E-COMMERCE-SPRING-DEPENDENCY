package com.ecommerce.services.WishList.Repository;

import com.ecommerce.services.WishList.Modals.FavouriteModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//@NoRepositoryBean
public interface FavouriteRepository extends MongoRepository<FavouriteModal,String> {

    @Query("{'user_id':?0}")
    public FavouriteModal findFavouriteParticularUser(String user_id);

}
