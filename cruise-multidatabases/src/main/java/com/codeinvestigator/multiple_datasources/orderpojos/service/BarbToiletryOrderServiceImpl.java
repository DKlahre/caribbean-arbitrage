package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletryOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbToiletryOrderRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbadosOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class BarbToiletryOrderServiceImpl implements BarbToiletryOrderService{


    @Autowired
    BarbToiletryOrderRepository barbToiletryOrderRepository;

    @Autowired
    SubmitOrderService submitOrderService;

    @Override
    public List<BarbToiletryOrder> getBarbToiletryOrders() {
        return (List<BarbToiletryOrder>)barbToiletryOrderRepository.findAll();
    }

    @Override
    public BarbToiletryOrder getBarbToiletryOrderById(Integer id) {
        return barbToiletryOrderRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public void deleteBarbToiletryOrder(Integer id){
        barbToiletryOrderRepository.deleteById(id);
    }

    @Override
    public BarbToiletryOrder saveBarbToiletryOrder(BarbToiletryOrder barbToiletryOrder) {
        return barbToiletryOrderRepository.save(barbToiletryOrder);
    }

    @Override
    public BarbToiletryOrder updateBarbToiletryOrder(BarbToiletryOrder newBarbToiletryOrder, Integer id) {

        SubmitOrder submitOrder = new SubmitOrder();
        Double costGrandTally = 0.0;
        Integer i = 0;
        submitOrderService.clearSubmitOrders();
        submitOrderService.insertDefaultRow();

        List<Object[]> costGrandTallyList = barbToiletryOrderRepository.findTotalOneRowCost();
        List<Object[]> idList = barbToiletryOrderRepository.findId();

        for (Object[] insideArray : costGrandTallyList){
            String useArray = Arrays.toString(insideArray);
            StringBuffer ta = new StringBuffer(useArray);
            ta.delete(useArray.length() - 1, useArray.length());
            ta.delete(0, 1);
            Double tempDec = Double.valueOf(String.valueOf(ta));

            String useArray2 = Arrays.toString(idList.get(i));
            StringBuffer ta2 = new StringBuffer(useArray2);
            ta2.delete(useArray2.length() - 1, useArray2.length());
            ta2.delete(0,1);
            Integer intVal = Integer.valueOf(String.valueOf(ta2));

            costGrandTally = costGrandTally + tempDec;

        }

        Double finalCostGrandTally = costGrandTally;


        return barbToiletryOrderRepository.findById(id)
                .map(barbToiletryOrder -> {
                    barbToiletryOrder.setCountry(newBarbToiletryOrder.getCountry());
                    barbToiletryOrder.setProvisioner(newBarbToiletryOrder.getProvisioner());
                    barbToiletryOrder.setItem(newBarbToiletryOrder.getItem());
                    barbToiletryOrder.setItemCostNat(newBarbToiletryOrder.getItemCostNat());
                    barbToiletryOrder.setItemCostUs(newBarbToiletryOrder.getItemCostUs());
                    barbToiletryOrder.setQuantity(newBarbToiletryOrder.getQuantity());
                    barbToiletryOrder.setItemTotalCostUs(newBarbToiletryOrder.getItemTotalCostUs());
                    barbToiletryOrder.setPurchDate(newBarbToiletryOrder.getPurchDate());
                    barbToiletryOrder.setAllItemsCost(finalCostGrandTally + newBarbToiletryOrder.getItemTotalCostUs());

                    submitOrder.setAllItemsCost(finalCostGrandTally + newBarbToiletryOrder.getItemTotalCostUs());
                    submitOrder.setProvisioner(newBarbToiletryOrder.getProvisioner());
                    submitOrder.setPurchDate(newBarbToiletryOrder.getPurchDate());
                    submitOrder.setCountry(newBarbToiletryOrder.getCountry());
                    submitOrderService.updateSubmitOrder(submitOrder, 1);

                    return barbToiletryOrderRepository.save(barbToiletryOrder);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void clearBarbToiletryOrders() {barbToiletryOrderRepository.clearTable();}

    @Override
    public void insertDefaultRow()
    { barbToiletryOrderRepository.insertRow();
    }
    @Override
    public void deleteAllBarbToiletryOrders(){
        barbToiletryOrderRepository.deleteAll();
    }

}