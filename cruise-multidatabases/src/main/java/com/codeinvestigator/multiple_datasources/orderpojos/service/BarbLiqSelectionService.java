package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbLiqSelection;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;

import java.util.List;

public interface BarbLiqSelectionService {

    BarbLiqSelection saveBarbLiqSelection(BarbLiqSelection barbLiqSelection);
    void deleteBarbLiqSelection(Integer id);
    List<BarbLiqSelection> getBarbLiqSelections();
    BarbLiqSelection getBarbLiqSelectionById(Integer id);
    BarbLiqSelection updateBarbLiqSelection(BarbLiqSelection newBarbLiqSelection, Integer id);

   void saveBarbLiqSelectionAIC (BarbLiqSelection bls, Double allItemsCost, Integer id, Integer i);

}
