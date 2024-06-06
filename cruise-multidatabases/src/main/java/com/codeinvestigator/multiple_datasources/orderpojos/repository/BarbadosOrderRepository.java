package com.codeinvestigator.multiple_datasources.orderpojos.repository;


import com.codeinvestigator.multiple_datasources.orderpojos.BarbadosOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BarbadosOrderRepository extends CrudRepository<BarbadosOrder, Integer> {
    @Transactional
    @Modifying
    @Query(value = "TRUNCATE barbados_order", nativeQuery = true)
    public void clearTable();

    @Transactional
    @Modifying
    @Query(value = "insert into barbados_order(country, provisioner, item, item_cost_nat, item_cost_us, quantity, item_total_cost_us, purch_date, all_items_cost) values (null, null, null, null, null, null, null, null, 0.0);" , nativeQuery = true)
    public void insertRow();

    @Query(value = "SELECT item_total_cost_us FROM barbados_order", nativeQuery = true)
    public List<Object[]> findTotalOneRowCost();

    @Query (value = "SELECT id FROM barbados_order", nativeQuery = true )
    public List<Object[]>findId();


}
