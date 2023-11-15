package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.trade.Country;
import com.codeinvestigator.multiple_datasources.trade.Product;
import com.codeinvestigator.multiple_datasources.trade.Provisioner;
import com.codeinvestigator.multiple_datasources.trade.TransactionDump;
import com.codeinvestigator.multiple_datasources.trade.repository.CountryRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.ProductRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.ProvisionerRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.TransactionDumpRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ProvisionerServiceImpl implements ProvisionerService {

    @Autowired
    ProvisionerRepository provisionerRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionDumpRepository transactionDumpRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<Provisioner> getProvisioners() {
        return (List<Provisioner>)provisionerRepository.findAll();
    }

    @Override
    public Provisioner saveProvisioner(Provisioner provisioner) {
        return provisionerRepository.save(provisioner);
    }

    @Override
    public void deleteProvisioner(Integer id){
        provisionerRepository.deleteById(id);
    }

    @Override
    public Provisioner getProvisionerById(Integer id){
        return provisionerRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public Provisioner updateProvisioner(Provisioner newProvisioner, Integer id) {
        return provisionerRepository.findById(id)
                .map(provisioner -> {
                    provisioner.setProvisionerName(newProvisioner.getProvisionerName());
                    provisioner.setCountryOfBusiness(newProvisioner.getCountryOfBusiness());
                    provisioner.setProductQuantity(newProvisioner.getProductQuantity());
                    provisioner.setPurchaseTotal(newProvisioner.getPurchaseTotal());
                    provisioner.setTransType(newProvisioner.getTransType());
                    return provisionerRepository.save(provisioner);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Provisioner saveProvisionerPC(Provisioner provisioner, Integer countryId, Integer productId) {

        Country country = countryRepository.findById(countryId).get();
        Product product = productRepository.findById(productId).get();
        provisioner.setCountry(country);
        provisioner.setProduct(product);

        if (provisioner.getTransType().equalsIgnoreCase("sell")){
            testSellTransaction(provisioner, productId);
        }

        TransactionDump transactionDump = new TransactionDump();

        transactionDump.setProvisionerName(provisioner.getProvisionerName());
        transactionDump.setCountryOfBusiness(provisioner.getCountryOfBusiness());
        transactionDump.setProductQuantity(provisioner.getProductQuantity());
        transactionDump.setPurchaseTotal(provisioner.getPurchaseTotal());
        transactionDump.setTransType(provisioner.getTransType());
        transactionDump.setPurchDate(provisioner.getPurchDate());
        transactionDump.setCountryId(provisioner.getCountry().getId());
        transactionDump.setProductId(provisioner.getProduct().getId());
        transactionDumpRepository.save(transactionDump);

        return provisionerRepository.save(provisioner);
    }


    public void testSellTransaction(Provisioner provisioner, Integer productId){

        List <TransactionDump> buyTransactions = transactionDumpRepository.findByTransTypeAndProductId("buy", productId);
        List <TransactionDump> sellTransactions = transactionDumpRepository.findByTransTypeAndProductId("sell", productId);

        int buyTransCount = 0;
        int sellTransCount = 0;
        int buyMinusSell = 0;

        for (TransactionDump insideArray: buyTransactions){
            buyTransCount = buyTransCount + insideArray.getProductQuantity();
        }
        for (TransactionDump insideArray2: sellTransactions){
            sellTransCount = sellTransCount + insideArray2.getProductQuantity();
        }

            buyMinusSell = buyTransCount - sellTransCount - provisioner.getProductQuantity();

        String productName = productService.getProductById(productId).getProductName();

//        if (buyMinusSell < 0){
//            throw new IllegalArgumentException("Not enough '" + productName +  "' onboard");
//        }


    }


    @Override
    public Provisioner getProvisionerPC(Integer countryId, Integer productId) {
        Optional<Provisioner> provisioner = provisionerRepository.findByCountryIdAndProductId(countryId, productId);
        if (provisioner.isPresent()) {
            return provisioner.get();
        } else {
            throw new UserNotFoundException(countryId);
        }
    }

    @Override
    public List<Provisioner> getProvisionersByCountryId(Integer id){
        return provisionerRepository.findByCountryId(id);
    }

    @Override
    public List<Provisioner> getProvisionersByProductId(Integer id){
        return provisionerRepository.findByProductId(id);
    }

}
