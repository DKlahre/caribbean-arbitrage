package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletry;
import java.util.List;

public interface BarbToiletryService {

    BarbToiletry saveBarbToiletryItem(BarbToiletry barbToiletry);
    void deleteBarbToiletryItem(Integer id);
    List<BarbToiletry> getBarbToiletryItems();
    BarbToiletry getBarbToiletryItemById(Integer id);
    BarbToiletry updateBarbToiletry(BarbToiletry newBarbToiletry, Integer id);
    void saveBarbToiletryAIC(BarbToiletry bt, Double allItemsCost, Integer id, Integer i);

}
