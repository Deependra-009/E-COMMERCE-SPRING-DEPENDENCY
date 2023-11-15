package com.ecommerce.services.Cart.Repository;

import com.ecommerce.services.Cart.Modals.CartModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//@NoRepositoryBean
public interface CartRepository extends MongoRepository<CartModal,String> {

    @Query("{'user_id':?0}")
    public CartModal findCartParicularUser(String user_id);

}
