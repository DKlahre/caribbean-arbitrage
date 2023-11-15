package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbadosOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

    @AllArgsConstructor
    @Service
    public class BarbadosOrderServiceImpl implements BarbadosOrderService {

        @Autowired
        BarbadosOrderRepository barbadosOrderRepository;

        @Autowired
        SubmitOrderService submitOrderService;

        @Override
        public List<BarbadosOrder> getBarbadosOrders() {

            return (List<BarbadosOrder>)barbadosOrderRepository.findAll();
        }

        @Override
        public BarbadosOrder getBarbadosOrderById(Integer id) {
            return barbadosOrderRepository.findById(id)
                    .orElseThrow(()-> new UserNotFoundException(id));
        }

        @Override
        public void deleteBarbadosOrder(Integer id){
            barbadosOrderRepository.deleteById(id);
        }

        @Override
        public BarbadosOrder saveBarbadosOrder(BarbadosOrder barbadosOrder) {
            return barbadosOrderRepository.save(barbadosOrder);
        }

        @Override
        public BarbadosOrder updateBarbadosOrder(BarbadosOrder newBarbadosOrder, Integer id) {

            SubmitOrder submitOrder = new SubmitOrder();
            Double costGrandTally = 0.0;
            Integer i = 0;
            submitOrderService.clearSubmitOrders();
            submitOrderService.insertDefaultRow();

            List<Object[]> costGrandTallyList = barbadosOrderRepository.findTotalOneRowCost();
            List<Object[]> idList = barbadosOrderRepository.findId();

            for (Object[] insideArray : costGrandTallyList){
                String useArray = Arrays.toString(insideArray);
                StringBuffer ta = new StringBuffer(useArray);
                ta.delete(useArray.length() - 1, useArray.length());
                ta.delete(0, 1);
                Double tempDec = Double.valueOf(String.valueOf(ta));

                    String useArray2 = Arrays.toString(idList.get(i));
                    StringBuffer sb2 = new StringBuffer(useArray2);
                    sb2.delete(useArray2.length() - 1, useArray2.length());
                    sb2.delete(0,1);
                    Integer intVal = Integer.valueOf(String.valueOf(sb2));

                costGrandTally = costGrandTally + tempDec;

            }

            Double finalCostGrandTally = costGrandTally;


            return barbadosOrderRepository.findById(id)
                    .map(barbadosOrder -> {
                        barbadosOrder.setCountry(newBarbadosOrder.getCountry());
                        barbadosOrder.setProvisioner(newBarbadosOrder.getProvisioner());
                        barbadosOrder.setItem(newBarbadosOrder.getItem());
                        barbadosOrder.setItemCostNat(newBarbadosOrder.getItemCostNat());
                        barbadosOrder.setItemCostUs(newBarbadosOrder.getItemCostUs());
                        barbadosOrder.setQuantity(newBarbadosOrder.getQuantity());
                        barbadosOrder.setItemTotalCostUs(newBarbadosOrder.getItemTotalCostUs());
                        barbadosOrder.setPurchDate(newBarbadosOrder.getPurchDate());
                        barbadosOrder.setAllItemsCost(finalCostGrandTally + newBarbadosOrder.getItemTotalCostUs());

                        submitOrder.setAllItemsCost(finalCostGrandTally + newBarbadosOrder.getItemTotalCostUs());
                        submitOrder.setProvisioner(newBarbadosOrder.getProvisioner());
                        submitOrder.setPurchDate(newBarbadosOrder.getPurchDate());
                        submitOrder.setCountry(newBarbadosOrder.getCountry());
                        submitOrderService.updateSubmitOrder(submitOrder, 1);

                        return barbadosOrderRepository.save(barbadosOrder);
                    }).orElseThrow(() -> new UserNotFoundException(id));
        }

        @Override
        public void clearBarbadosOrders() {barbadosOrderRepository.clearTable();}

        @Override
        public void insertDefaultRow()
        { barbadosOrderRepository.insertRow();
                    }
        @Override
        public void deleteAllBarbadosOrders(){
            barbadosOrderRepository.deleteAll();
        }

    }




