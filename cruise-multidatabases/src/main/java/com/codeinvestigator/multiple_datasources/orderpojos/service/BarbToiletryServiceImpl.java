package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletry;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletryOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbToiletryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@Service
public class BarbToiletryServiceImpl implements BarbToiletryService{

    @Autowired
    BarbToiletryRepository barbToiletryRepository;

    @Autowired
    SubmitOrderService submitOrderService;

    @Autowired
    BarbToiletryOrderService barbToiletryOrderService;

    @Override
    public BarbToiletry saveBarbToiletryItem(BarbToiletry barbToiletry) {
        return barbToiletryRepository.save(barbToiletry);
    }

    @Override
    public void deleteBarbToiletryItem(Integer id){
        barbToiletryRepository.deleteById(id);
    }

    @Override
    public BarbToiletry getBarbToiletryItemById(Integer id){
        return barbToiletryRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


    @Override
    public BarbToiletry updateBarbToiletry(BarbToiletry newBarbToiletry, Integer id) {


        return barbToiletryRepository.findById(id)
                .map(barbToiletry -> {
                    barbToiletry.setCountry(newBarbToiletry.getCountry());
                    barbToiletry.setProvisioner(newBarbToiletry.getProvisioner());
                    barbToiletry.setItem(newBarbToiletry.getItem());
                    barbToiletry.setItemCostNat(newBarbToiletry.getItemCostNat());
                    barbToiletry.setItemCostUs(newBarbToiletry.getItemCostUs());
                    barbToiletry.setQuantity(newBarbToiletry.getQuantity());
                    barbToiletry.setItemTotalCostUs(newBarbToiletry.getItemTotalCostUs());
                    barbToiletry.setPurchDate(newBarbToiletry.getPurchDate());
                    barbToiletry.setAllItemsCost(newBarbToiletry.getAllItemsCost());
                    return barbToiletryRepository.save(barbToiletry);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @Override
    public List<BarbToiletry> getBarbToiletryItems() {

        Double tempDec = 0.0;
        Integer tempId = 0;
        Integer i = 0;

        List<Object[]> totalAmount = barbToiletryRepository.findTotal();
        List<Object[]> idList = barbToiletryRepository.findId();
        barbToiletryOrderService.clearBarbToiletryOrders();
        barbToiletryOrderService.insertDefaultRow();
        submitOrderService.clearSubmitOrders();
        submitOrderService.insertDefaultRow();


        for (Object[] insideArray : totalAmount){

            String useArray = Arrays.toString(insideArray);
            StringBuffer sb = new StringBuffer(useArray);
            sb.delete(useArray.length() - 1, useArray.length());
            sb.delete(0, 1);
            Double d = Double.valueOf(String.valueOf(sb));
            tempDec = d + tempDec;

            String useArray2 = Arrays.toString(idList.get(i));
            StringBuffer sb2 = new StringBuffer(useArray2);
            sb2.delete(useArray2.length() - 1, useArray2.length());
            sb2.delete(0,1);
            Integer intVal = Integer.valueOf(String.valueOf(sb2));

            i = i + 1;
            BarbToiletry bt = getBarbToiletryItemById(intVal);
            saveBarbToiletryAIC(bt, tempDec, intVal, i);
        }

        return (List<BarbToiletry>)barbToiletryRepository.findAll();
    }

    @Override
    public void saveBarbToiletryAIC (BarbToiletry bt, Double newAllItemsCost, Integer id, Integer indexFix) {


        BarbToiletryOrder barbToiletryOrder = barbToiletryOrderService.getBarbToiletryOrderById(1);


        bt.setAllItemsCost(newAllItemsCost);

        barbToiletryOrder.setId(id);
        barbToiletryOrder.setCountry(bt.getCountry());
        barbToiletryOrder.setProvisioner(bt.getProvisioner());
        barbToiletryOrder.setItem(bt.getItem());
        barbToiletryOrder.setItemCostNat(bt.getItemCostNat());
        barbToiletryOrder.setItemCostUs(bt.getItemCostUs());
        barbToiletryOrder.setQuantity(bt.getQuantity());
        barbToiletryOrder.setItemTotalCostUs(bt.getItemTotalCostUs());
        barbToiletryOrder.setPurchDate(bt.getPurchDate());
        barbToiletryOrder.setAllItemsCost(bt.getAllItemsCost());


        barbToiletryOrder.setId(indexFix);
        barbToiletryOrder.setCountry(barbToiletryOrder.getCountry());
        barbToiletryOrder.setProvisioner(barbToiletryOrder.getProvisioner());
        barbToiletryOrder.setItem(barbToiletryOrder.getItem());
        barbToiletryOrder.setItemCostNat(barbToiletryOrder.getItemCostNat());
        barbToiletryOrder.setItemCostUs(barbToiletryOrder.getItemTotalCostUs());
        barbToiletryOrder.setQuantity(barbToiletryOrder.getQuantity());
        barbToiletryOrder.setItemTotalCostUs(barbToiletryOrder.getItemTotalCostUs());
        barbToiletryOrder.setPurchDate(barbToiletryOrder.getPurchDate());
        barbToiletryOrder.setAllItemsCost(barbToiletryOrder.getAllItemsCost());

        barbToiletryOrderService.saveBarbToiletryOrder(barbToiletryOrder);
    }


}
