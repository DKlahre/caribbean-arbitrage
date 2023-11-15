package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.trade.Provisioner;
import java.util.List;

public interface ProvisionerService {

    List<Provisioner> getProvisioners();

    Provisioner saveProvisioner(Provisioner provisioner);

    void deleteProvisioner(Integer id);

    Provisioner getProvisionerById(Integer id);

    Provisioner updateProvisioner(Provisioner newProvisioner, Integer id);

    Provisioner saveProvisionerPC(Provisioner provisioner, Integer countryId, Integer productId);

    List<Provisioner> getProvisionersByCountryId(Integer id);

    List<Provisioner> getProvisionersByProductId(Integer id);

    Provisioner getProvisionerPC(Integer countryId, Integer productId);

    void testSellTransaction(Provisioner provisioner, Integer productId);
}
