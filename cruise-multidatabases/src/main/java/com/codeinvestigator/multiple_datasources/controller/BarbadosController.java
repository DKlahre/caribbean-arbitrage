package com.codeinvestigator.multiple_datasources.controller;
import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.*;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbadosOrderRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
public class BarbadosController {


    @Autowired
    private BarbadosOrderService barbadosOrderService;

    @Autowired
    private BarbLiqSelectionService barbLiqSelectionService;

    @Autowired
    private SubmitOrderService submitOrderService;

    @Autowired
    private BarbToiletryService barbToiletryService;

    @Autowired
    private BarbToiletryOrderService barbToiletryOrderService;

    @PostMapping("/barbadosorder")
    ResponseEntity<BarbadosOrder> newBarbadosOrder (@RequestBody BarbadosOrder newBarbadosOrder){
        return new ResponseEntity<>(barbadosOrderService.saveBarbadosOrder(newBarbadosOrder), HttpStatus.CREATED);
    }

    @GetMapping("/barbadosorders")
    public ResponseEntity<List<BarbadosOrder>> getAllBarbadosOrders() {
        return new ResponseEntity<>(barbadosOrderService.getBarbadosOrders(), HttpStatus.OK);
    }

    @DeleteMapping("/barbadosorder/{id}")
    public ResponseEntity<HttpStatus> deleteBarbadosOrderById(@PathVariable Integer id) {
        barbadosOrderService.deleteBarbadosOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/barbadosorder/{id}")
    public ResponseEntity<BarbadosOrder> updateBarbadosOrder( @RequestBody BarbadosOrder newBarbadosOrder, @PathVariable Integer id ){
        return new ResponseEntity<>(barbadosOrderService.updateBarbadosOrder(newBarbadosOrder,id), HttpStatus.OK);
    }

    @GetMapping("/barbadosorder/{id}")
    public ResponseEntity<BarbadosOrder> getBarbadosOrderById(@PathVariable Integer id){
        return new ResponseEntity<>(barbadosOrderService.getBarbadosOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/barbliqselection")
    ResponseEntity<BarbLiqSelection> newBarbLiqSelection (@RequestBody BarbLiqSelection newBarbLiqSelection){
        return new ResponseEntity<>(barbLiqSelectionService.saveBarbLiqSelection(newBarbLiqSelection), HttpStatus.CREATED);
    }

    @DeleteMapping("/barbliqselection/{id}")
    public ResponseEntity<HttpStatus> deleteBarbLiqSelectionById(@PathVariable Integer id) {
        barbLiqSelectionService.deleteBarbLiqSelection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/barbliqselections")
    public ResponseEntity<List<BarbLiqSelection>> getAllBarbLiqSelections() {
        return new ResponseEntity<>(barbLiqSelectionService.getBarbLiqSelections(), HttpStatus.OK);
    }

    @GetMapping("/barbliqselection/{id}")
    public ResponseEntity<BarbLiqSelection> getBarbLiqSelectionById(@PathVariable Integer id){
        return new ResponseEntity<>(barbLiqSelectionService.getBarbLiqSelectionById(id), HttpStatus.OK);
    }

    @PutMapping("/barbliqselection/{id}")
    public ResponseEntity<BarbLiqSelection> updateBarbLiqSelection(@RequestBody BarbLiqSelection newBarbLiqSelection, @PathVariable Integer id ){
        return new ResponseEntity<>(barbLiqSelectionService.updateBarbLiqSelection(newBarbLiqSelection,id), HttpStatus.OK);
    }

    @GetMapping("/barbtoiletryitems")
    public ResponseEntity<List<BarbToiletry>> getAllBarbToiletryItems() {
        return new ResponseEntity<>(barbToiletryService.getBarbToiletryItems(), HttpStatus.OK);
    }

    @GetMapping("/barbtoiletryitem/{id}")
    public ResponseEntity<BarbToiletry> getBarbToiletryItemById(@PathVariable Integer id){
        return new ResponseEntity<>(barbToiletryService.getBarbToiletryItemById(id), HttpStatus.OK);
    }

    @PostMapping("/barbtoiletryitem")
    ResponseEntity<BarbToiletry> newBarbToiletryItem (@RequestBody BarbToiletry newBarbToiletry){
        return new ResponseEntity<>(barbToiletryService.saveBarbToiletryItem(newBarbToiletry), HttpStatus.CREATED);
    }

    @DeleteMapping("/barbtoiletryitem/{id}")
    public ResponseEntity<HttpStatus> deleteBarbToiletryItemById(@PathVariable Integer id) {
        barbToiletryService.deleteBarbToiletryItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/barbtoiletryitem/{id}")
    public ResponseEntity<BarbToiletry> updateBarbToiletry(@RequestBody BarbToiletry newBarbToiletry, @PathVariable Integer id ){
        return new ResponseEntity<>(barbToiletryService.updateBarbToiletry(newBarbToiletry,id), HttpStatus.OK);
    }

    @PostMapping("/barbtoiletryorder")
    ResponseEntity<BarbToiletryOrder> newBarbToiletryOrder (@RequestBody BarbToiletryOrder newBarbToiletryOrder){
        return new ResponseEntity<>(barbToiletryOrderService.saveBarbToiletryOrder(newBarbToiletryOrder), HttpStatus.CREATED);
    }

    @GetMapping("/barbtoiletryorders")
    public ResponseEntity<List<BarbToiletryOrder>> getAllBarbToiletryOrders() {
        return new ResponseEntity<>(barbToiletryOrderService.getBarbToiletryOrders(), HttpStatus.OK);
    }

    @DeleteMapping("/barbtoiletryorder/{id}")
    public ResponseEntity<HttpStatus> deleteBarbToiletryOrderById(@PathVariable Integer id) {
        barbToiletryOrderService.deleteBarbToiletryOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/barbtoiletryorder/{id}")
    public ResponseEntity<BarbToiletryOrder> updateBarbToiletryOrder( @RequestBody BarbToiletryOrder newBarbToiletryOrder, @PathVariable Integer id ){
        return new ResponseEntity<>(barbToiletryOrderService.updateBarbToiletryOrder(newBarbToiletryOrder,id), HttpStatus.OK);
    }

    @GetMapping("/barbtoiletryorder/{id}")
    public ResponseEntity<BarbToiletryOrder> getBarbToiletryOrderById(@PathVariable Integer id){
        return new ResponseEntity<>(barbToiletryOrderService.getBarbToiletryOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/submitorder")
    ResponseEntity<SubmitOrder> newSubmitOrder (@RequestBody SubmitOrder newSubmitOrder){
        return new ResponseEntity<>(submitOrderService.saveSubmitOrder(newSubmitOrder), HttpStatus.CREATED);
    }

    @DeleteMapping("/submitorder/{id}")
    public ResponseEntity<HttpStatus> deleteSubmitOrderById(@PathVariable Integer id) {
        submitOrderService.deleteSubmitOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/submitorders")
    public ResponseEntity<List<SubmitOrder>> getAllSubmitOrders() {
        return new ResponseEntity<>(submitOrderService.getSubmitOrders(), HttpStatus.OK);
    }

    @GetMapping("/submitorder/{id}")
    public ResponseEntity<SubmitOrder> getSubmitOrderById(@PathVariable Integer id){
        return new ResponseEntity<>(submitOrderService.getSubmitOrderById(id), HttpStatus.OK);
    }

    @PutMapping("/submitorder/{id}")
    public ResponseEntity<SubmitOrder> updateSubmitOrder(@RequestBody SubmitOrder newSubmitOrder, @PathVariable Integer id ){
        return new ResponseEntity<>(submitOrderService.updateSubmitOrder(newSubmitOrder,id), HttpStatus.OK);
    }


}
