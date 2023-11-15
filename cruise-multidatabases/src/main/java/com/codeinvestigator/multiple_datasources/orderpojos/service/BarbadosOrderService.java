package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;

import java.util.List;

public interface BarbadosOrderService{
    List<BarbadosOrder> getBarbadosOrders();
    BarbadosOrder getBarbadosOrderById(Integer id);
    void deleteBarbadosOrder(Integer id);
    BarbadosOrder saveBarbadosOrder(BarbadosOrder barbadosOrder);
    BarbadosOrder updateBarbadosOrder(BarbadosOrder barbadosOrder, Integer id );

    void clearBarbadosOrders();
     void insertDefaultRow();
    void deleteAllBarbadosOrders();
}


