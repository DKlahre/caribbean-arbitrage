package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.SubmitOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubmitOrderServiceImpl implements  SubmitOrderService{

    @Autowired
    SubmitOrderRepository submitOrderRepository;

    @Override
    public SubmitOrder saveSubmitOrder(SubmitOrder submitOrder) {
        return submitOrderRepository.save(submitOrder);
    }

    @Override
    public void deleteSubmitOrder(Integer id){
        submitOrderRepository.deleteById(id);
    }

    @Override
    public List<SubmitOrder> getSubmitOrders() {

        return (List<SubmitOrder>)submitOrderRepository.findAll();
    }

    @Override
    public SubmitOrder getSubmitOrderById(Integer id) {
        return submitOrderRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public SubmitOrder updateSubmitOrder(SubmitOrder newSubmitOrder, Integer id) {
        return submitOrderRepository.findById(id)
                .map(submitOrder -> {
                    submitOrder.setCountry(newSubmitOrder.getCountry());
                    submitOrder.setProvisioner(newSubmitOrder.getProvisioner());
                    submitOrder.setItem(newSubmitOrder.getItem());
                    submitOrder.setItemCostNat(newSubmitOrder.getItemCostNat());
                    submitOrder.setItemCostUs(newSubmitOrder.getItemCostUs());
                    submitOrder.setQuantity(newSubmitOrder.getQuantity());
                    submitOrder.setItemTotalCostUs(newSubmitOrder.getItemTotalCostUs());
                    submitOrder.setPurchDate(newSubmitOrder.getPurchDate());
                    submitOrder.setAllItemsCost(newSubmitOrder.getAllItemsCost());
                    return submitOrderRepository.save(submitOrder);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void clearSubmitOrders() {
        submitOrderRepository.clearTable();
    }

    @Override
    public void insertDefaultRow() {
        submitOrderRepository.insertRow();
    }


}
