package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.trade.Product;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    List<Product>getProductsByCountry(Integer countryId);
    List<Product> getProductsByCountryAndTransAvailable(Integer productDescription, String transAvailable);
    List<Product> getByProductDescriptionAndTransAvailable(String productDescription, String transAvailable);
    List<Product> getByProductDescription(String productDescription);
    Product saveProduct(Product product);
    Product saveProductPlusCountry(Product product, Integer countryId);
    void deleteProduct(Integer id);
    Product getProductById(Integer id);
    Product updateProduct(Product newProduct, Integer id);

}
