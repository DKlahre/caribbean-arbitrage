package com.codeinvestigator.multiple_datasources.orderpojos.repository;

import com.codeinvestigator.multiple_datasources.orderpojos.BarbLiqSelection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BarbLiqSelectionRepository extends CrudRepository<BarbLiqSelection, Integer> {
    @Query(value = "SELECT item_total_cost_us FROM barb_liq_selection", nativeQuery = true)
    public List<Object[]> findTotal();
    @Query (value = "SELECT id FROM barb_liq_selection", nativeQuery = true )
    public List<Object[]>findId();
}
