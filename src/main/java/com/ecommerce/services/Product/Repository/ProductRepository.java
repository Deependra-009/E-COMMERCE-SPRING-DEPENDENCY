package com.ecommerce.services.Product.Repository;

import com.ecommerce.services.Product.Modals.ProductModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductModal,String> {

    @Query("{'product_id':?0}")
    ProductModal findParticularProduct(String product_id);

    @Query("{ 'product_title' : { $regex: ?0 , $options: 'i' } }")
    List<ProductModal> searchData(String search_text);

}
