package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.trade.Country;
import com.codeinvestigator.multiple_datasources.trade.Product;
import com.codeinvestigator.multiple_datasources.trade.repository.CountryRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Product> getProducts() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product saveProductPlusCountry(Product product, Integer countryId){
        Country country = countryRepository.findById(countryId).get();
        product.setCountry(country);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Integer id){
        return productRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public List<Product>getProductsByCountry(Integer countryId){
        return productRepository.findByCountryId(countryId);
    }

    @Override
    public List<Product> getProductsByCountryAndTransAvailable(Integer productDescription, String transAvailable) {
        return productRepository.findByCountryIdAndTransAvailable(productDescription, transAvailable) ;
    }

    @Override
    public List<Product> getByProductDescriptionAndTransAvailable(String productDescription, String transAvailable) {
        return productRepository.findByProductDescriptionAndTransAvailable(productDescription, transAvailable) ;
    }

    @Override
    public List<Product> getByProductDescription(String productDescription) {
        return productRepository.findByProductDescription(productDescription) ;
    }

    @Override
    public Product updateProduct(Product newProduct, Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setProductDescription(newProduct.getProductDescription());
                    product.setProductPrice(newProduct.getProductPrice());
                    product.setTransAvailable(newProduct.getTransAvailable());
                    product.setCountry(newProduct.getCountry());
                    return productRepository.save(product);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

}
