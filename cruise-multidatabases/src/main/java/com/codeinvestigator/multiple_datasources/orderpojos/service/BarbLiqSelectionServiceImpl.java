package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.emp.Employees;
import com.codeinvestigator.multiple_datasources.emp.EmployeesRepository;
import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbLiqSelection;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbLiqSelectionRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbadosOrderRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.SubmitOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BarbLiqSelectionServiceImpl implements BarbLiqSelectionService {

    @Autowired
    BarbLiqSelectionRepository barbLiqSelectionRepository;

    @Autowired
    SubmitOrderRepository submitOrderRepository;

    @Autowired
    BarbadosOrderRepository barbadosOrderRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    BarbadosOrderService barbadosOrderService;

    @Autowired
    SubmitOrderService submitOrderService;

    @Override
    public BarbLiqSelection saveBarbLiqSelection(BarbLiqSelection barbLiqSelection) {
        return barbLiqSelectionRepository.save(barbLiqSelection);
    }

    @Override
    public void deleteBarbLiqSelection(Integer id){
        barbLiqSelectionRepository.deleteById(id);
    }

    @Override
    public List<BarbLiqSelection> getBarbLiqSelections() {

        Double tempDec = 0.0;
        Integer tempId = 0;
        Integer i = 0;

        List<Object[]> totalAmount = barbLiqSelectionRepository.findTotal();
        List<Object[]> idList = barbLiqSelectionRepository.findId();
        barbadosOrderService.clearBarbadosOrders();
        barbadosOrderService.insertDefaultRow();
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
                BarbLiqSelection bls = getBarbLiqSelectionById(intVal);
                saveBarbLiqSelectionAIC(bls, tempDec, intVal, i);
                }

        return (List<BarbLiqSelection>)barbLiqSelectionRepository.findAll();
    }

    @Override
    public BarbLiqSelection getBarbLiqSelectionById(Integer id){
        return barbLiqSelectionRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public BarbLiqSelection updateBarbLiqSelection(BarbLiqSelection newBarbLiqSelection, Integer id) {

        return barbLiqSelectionRepository.findById(id)
                .map(barbLiqSelection -> {
                    barbLiqSelection.setCountry(newBarbLiqSelection.getCountry());
                    barbLiqSelection.setProvisioner(newBarbLiqSelection.getProvisioner());
                    barbLiqSelection.setItem(newBarbLiqSelection.getItem());
                    barbLiqSelection.setItemCostNat(newBarbLiqSelection.getItemCostNat());
                    barbLiqSelection.setItemCostUs(newBarbLiqSelection.getItemCostUs());
                    barbLiqSelection.setQuantity(newBarbLiqSelection.getQuantity());
                    barbLiqSelection.setItemTotalCostUs(newBarbLiqSelection.getItemTotalCostUs());
                    barbLiqSelection.setPurchDate(newBarbLiqSelection.getPurchDate());
                    barbLiqSelection.setAllItemsCost(newBarbLiqSelection.getAllItemsCost());
                    return barbLiqSelectionRepository.save(barbLiqSelection);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @Override
    public void saveBarbLiqSelectionAIC (BarbLiqSelection bls, Double newAllItemsCost, Integer id, Integer indexFix) {


           BarbadosOrder barbadosOrder = barbadosOrderService.getBarbadosOrderById(1);

                bls.setAllItemsCost(newAllItemsCost);

                barbadosOrder.setId(id);
                barbadosOrder.setCountry(bls.getCountry());
                barbadosOrder.setProvisioner(bls.getProvisioner());
                barbadosOrder.setItem(bls.getItem());
                barbadosOrder.setItemCostNat(bls.getItemCostNat());
                barbadosOrder.setItemCostUs(bls.getItemCostUs());
                barbadosOrder.setQuantity(bls.getQuantity());
                barbadosOrder.setItemTotalCostUs(bls.getItemTotalCostUs());
                barbadosOrder.setPurchDate(bls.getPurchDate());
                barbadosOrder.setAllItemsCost(bls.getAllItemsCost());


                barbadosOrder.setId(indexFix);
                barbadosOrder.setCountry(barbadosOrder.getCountry());
                barbadosOrder.setProvisioner(barbadosOrder.getProvisioner());
                barbadosOrder.setItem(barbadosOrder.getItem());
                barbadosOrder.setItemCostNat(barbadosOrder.getItemCostNat());
                barbadosOrder.setItemCostUs(barbadosOrder.getItemTotalCostUs());
                barbadosOrder.setQuantity(barbadosOrder.getQuantity());
                barbadosOrder.setItemTotalCostUs(barbadosOrder.getItemTotalCostUs());
                barbadosOrder.setPurchDate(barbadosOrder.getPurchDate());
                barbadosOrder.setAllItemsCost(barbadosOrder.getAllItemsCost());

                barbadosOrderService.saveBarbadosOrder(barbadosOrder);

    }



}
