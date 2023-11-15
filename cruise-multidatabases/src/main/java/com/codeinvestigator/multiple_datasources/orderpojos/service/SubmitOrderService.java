package com.codeinvestigator.multiple_datasources.orderpojos.service;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbLiqSelection;
import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;

import java.util.List;

public interface SubmitOrderService {

    SubmitOrder saveSubmitOrder(SubmitOrder submitOrder);

    void deleteSubmitOrder(Integer id);

    List <SubmitOrder> getSubmitOrders();

    SubmitOrder getSubmitOrderById(Integer id);
    SubmitOrder updateSubmitOrder(SubmitOrder newSubmitOrder, Integer id );

    void clearSubmitOrders();

    void insertDefaultRow();
}
