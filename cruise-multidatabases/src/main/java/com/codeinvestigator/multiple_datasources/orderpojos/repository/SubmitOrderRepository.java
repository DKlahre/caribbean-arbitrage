package com.codeinvestigator.multiple_datasources.orderpojos.repository;

import com.codeinvestigator.multiple_datasources.orderpojos.SubmitOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface SubmitOrderRepository extends CrudRepository <SubmitOrder,Integer> {

    @Transactional
    @Modifying
    @Query(value = "TRUNCATE submit_order", nativeQuery = true)
    public void clearTable();

    @Transactional
    @Modifying
    @Query(value = "insert into submit_order(country, provisioner, item, item_cost_nat, item_cost_us, quantity, item_total_cost_us, purch_date, all_items_cost) values (null, null, null, null, null, null, null, null, 0.0);" , nativeQuery = true)
    public void insertRow();

}
