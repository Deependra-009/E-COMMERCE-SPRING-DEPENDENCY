package com.ecommerce.services.Product.ServiceImplementation;

import com.ecommerce.services.Product.Modals.ProductModal;
import com.ecommerce.services.Product.Repository.ProductRepository;
import com.ecommerce.services.Product.Service.ProductService;
import com.ecommerce.services.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductModal addProductInDatabase(ProductModal productModal) {

        ProductModal productModal1=this.productRepository.findParticularProduct(productModal.getProduct_id());
        if(productModal1==null){
            return this.addProductInDatabase(productModal);
        }
        return productModal1;
    }

    @Override
    public ProductModal getOneProductFromDatabase(String productId) {
        return this.productRepository.findParticularProduct(productId);
    }

    @Override
    public List<ProductModal> getAllProductFromDatabase() {
        return this.productRepository.findAll();
    }

    @Override
    public List<ProductModal> getProductBySearch(String searchText) {
        return this.productRepository.searchData(searchText);
    }


}
