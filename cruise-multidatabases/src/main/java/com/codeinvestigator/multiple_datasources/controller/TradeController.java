package com.codeinvestigator.multiple_datasources.controller;
import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletryOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.service.BarbToiletryOrderService;
import com.codeinvestigator.multiple_datasources.orderpojos.service.BarbToiletryService;
import com.codeinvestigator.multiple_datasources.pass.Passengers;
import com.codeinvestigator.multiple_datasources.trade.Country;
import com.codeinvestigator.multiple_datasources.trade.repository.CountryRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.ProductRepository;
import com.codeinvestigator.multiple_datasources.trade.repository.TransactionDumpRepository;
import com.codeinvestigator.multiple_datasources.trade.service.CountryService;
import com.codeinvestigator.multiple_datasources.trade.*;
import com.codeinvestigator.multiple_datasources.trade.service.*;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
public class TradeController {

    @Autowired
    CountryService countryService;

    @Autowired
    ProductService productService;

    @Autowired
    ProvisionerService provisionerService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionDumpRepository transactionDumpRepository;

    @Autowired
    TransactionDumpService transactionDumpService;


    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }
    @PostMapping("/country")
    public ResponseEntity<Country> newCountry (@RequestBody Country newCountry){
        return new ResponseEntity<>(countryService.saveCountry(newCountry), HttpStatus.CREATED);
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<HttpStatus> deleteCountryById(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getSingleCountry(@PathVariable Integer id){
        return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
    }

    @PutMapping("/country/{id}")
    public ResponseEntity<Country> updateCountry(@RequestBody Country newCountry, @PathVariable Integer id ){
        return new ResponseEntity<>(countryService.updateCountry(newCountry,id), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> newProduct (@RequestBody Product newProduct){
        return new ResponseEntity<>(productService.saveProduct(newProduct), HttpStatus.CREATED);
    }

    @PostMapping("/productpluscountry/{countryId}")
    public ResponseEntity<Product> newProductPlusCountry (@RequestBody Product newProduct, @PathVariable Integer countryId){
        return new ResponseEntity<>(productService.saveProductPlusCountry(newProduct, countryId), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @PathVariable Integer id ){
        return new ResponseEntity<>(productService.updateProduct(newProduct,id), HttpStatus.OK);
    }
    @GetMapping("/productsbycountry/{countryId}")
    public ResponseEntity<List<Product>> getProductsByCountry(@PathVariable Integer countryId){
        return new ResponseEntity<List<Product>>(productService.getProductsByCountry(countryId), HttpStatus.OK);
    }

    @GetMapping("/prodsbycountry/country/{countryId}/transavailable/{transAvailable}")
    public ResponseEntity<List<Product>> getProductsByCountryAndTransAvailable(@PathVariable Integer countryId, @PathVariable String transAvailable){
        return new ResponseEntity<List<Product>>(productService.getProductsByCountryAndTransAvailable(countryId, transAvailable), HttpStatus.OK);
    }

    @GetMapping("/countriesbyprod/productdesc/{productDescription}/transavailable/{transAvailable}")
    public ResponseEntity<List<Product>> getByProductDescriptionAndTransAvailable(@PathVariable String productDescription, @PathVariable String transAvailable){
        return new ResponseEntity<List<Product>>(productService.getByProductDescriptionAndTransAvailable(productDescription, transAvailable), HttpStatus.OK);
    }

    @GetMapping("/productbydescription/productdesc/{productDescription}")
    public ResponseEntity<List<Product>> getByProductDescription(@PathVariable String productDescription){
        return new ResponseEntity<List<Product>>(productService.getByProductDescription(productDescription), HttpStatus.OK);
    }

    @GetMapping("/provisioners")
    public ResponseEntity<List<Provisioner>> getAllProvisioners() {
        return new ResponseEntity<>(provisionerService.getProvisioners(), HttpStatus.OK);
    }

    @PostMapping("/provisioner")
    public ResponseEntity<Provisioner> newProvisioner (@RequestBody Provisioner newProvisioner){
        return new ResponseEntity<>(provisionerService.saveProvisioner(newProvisioner), HttpStatus.CREATED);
    }

    @DeleteMapping("/provisioner/{id}")
    public ResponseEntity<HttpStatus> deleteProvisionerById(@PathVariable Integer id) {
        provisionerService.deleteProvisioner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/provisioner/{id}")
    public ResponseEntity<Provisioner> getSingleProvisioner(@PathVariable Integer id){
        return new ResponseEntity<>(provisionerService.getProvisionerById(id), HttpStatus.OK);
    }

    @PutMapping("/provisioner/{id}")
    public ResponseEntity<Provisioner> updateProvisioner(@RequestBody Provisioner newProvisioner, @PathVariable Integer id ){
        return new ResponseEntity<>(provisionerService.updateProvisioner(newProvisioner,id), HttpStatus.OK);
    }

    @PostMapping("/country/{countryId}/product/{productId}")
    public ResponseEntity<Provisioner> saveProvisionerPC(@Valid @RequestBody Provisioner provisioner, @PathVariable Integer countryId, @PathVariable Integer productId) {
          Product prod = productRepository.findById(productId).get();
          Double price = prod.getProductPrice();
          provisioner.setPurchaseTotal(price);
        return new ResponseEntity<>(provisionerService.saveProvisionerPC(provisioner, countryId, productId), HttpStatus.CREATED);
    }

    @GetMapping("/provisionerscountryid/{countryId}")
    public ResponseEntity<List<Provisioner>> getProvsCountryId(@PathVariable Integer countryId) {
        return new ResponseEntity<>(provisionerService.getProvisionersByCountryId(countryId), HttpStatus.OK);
    }

    @GetMapping("/provisionersproductid/{productId}")
    public ResponseEntity<List<Provisioner>> getProvisionersProdId(@PathVariable Integer productId) {
        return new ResponseEntity<>(provisionerService.getProvisionersByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}/product/{productId}")
    public ResponseEntity<Provisioner> getProvisionerPC(@PathVariable Integer countryId, @PathVariable Integer productId) {
        return new ResponseEntity<>(provisionerService.getProvisionerPC(countryId, productId), HttpStatus.OK);
    }

    @GetMapping("/transactiondumps")
    public ResponseEntity<Iterable<TransactionDump>> getAllTransactions() {
        return new ResponseEntity<> (transactionDumpRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/transactionsbetweendates/firstdate/{firstDate}/seconddate/{secondDate}/transtype/{transType}")
    public ResponseEntity<List<TransactionDump>> getTransactionsBetweenDates(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date firstDate,
                                                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date secondDate,
                                                                             @PathVariable String transType) {
        return new ResponseEntity<>(transactionDumpService.getTransactionDumpsBetweenDates(firstDate, secondDate, transType), HttpStatus.OK);
    }

    @DeleteMapping("/transactiondump/{id}")
    public ResponseEntity<HttpStatus> deleteTransactionDumpById(@PathVariable Integer id) {
        transactionDumpService.deleteTransactionDump(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/transactiondump/{id}")
    public ResponseEntity<TransactionDump> getSingleTransactionById(@PathVariable Integer id){
        return new ResponseEntity<>(transactionDumpService.getTransactionDumpById(id), HttpStatus.OK);
    }

}
