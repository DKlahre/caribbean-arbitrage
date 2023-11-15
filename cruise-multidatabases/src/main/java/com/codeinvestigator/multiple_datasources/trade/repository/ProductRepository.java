package com.codeinvestigator.multiple_datasources.trade.repository;

import com.codeinvestigator.multiple_datasources.trade.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByCountryId(Integer countryId);
    List<Product> findByCountryIdAndTransAvailable(Integer countryId, String transAvailable);
    List<Product> findByProductDescriptionAndTransAvailable(String productDescription, String transAvailable);
    List<Product> findByProductDescription(String productDescription);

}
