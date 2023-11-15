package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbToiletryOrder;
import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;

import java.util.List;

public interface BarbToiletryOrderService {
    List<BarbToiletryOrder> getBarbToiletryOrders();
    BarbToiletryOrder getBarbToiletryOrderById(Integer id);
    void deleteBarbToiletryOrder(Integer id);
    BarbToiletryOrder saveBarbToiletryOrder(BarbToiletryOrder barbToiletryOrder);
    BarbToiletryOrder updateBarbToiletryOrder(BarbToiletryOrder barbToiletryOrder, Integer id);

    void clearBarbToiletryOrders();
    void insertDefaultRow();
    void deleteAllBarbToiletryOrders();
}
