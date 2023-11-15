package com.ecommerce.services.Product.Service;


import com.ecommerce.services.Product.Modals.ProductModal;
import com.ecommerce.services.SuccessMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public ProductModal addProductInDatabase(ProductModal productModal);

    public ProductModal getOneProductFromDatabase(String productId);

    public List<ProductModal> getAllProductFromDatabase();

    public List<ProductModal> getProductBySearch(String searchText);

}
