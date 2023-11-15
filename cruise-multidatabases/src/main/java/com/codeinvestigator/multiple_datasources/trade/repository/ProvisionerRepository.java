package com.codeinvestigator.multiple_datasources.trade.repository;

import com.codeinvestigator.multiple_datasources.trade.Provisioner;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProvisionerRepository extends CrudRepository<Provisioner, Integer> {
    Optional<Provisioner> findByCountryIdAndProductId(Integer countryId, Integer productId);
    List<Provisioner> findByCountryId(Integer countryId);
    List<Provisioner> findByProductId(Integer productId);
}
