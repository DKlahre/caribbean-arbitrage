package com.codeinvestigator.multiple_datasources.trade.repository;

import com.codeinvestigator.multiple_datasources.trade.TransactionDump;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface TransactionDumpRepository extends CrudRepository<TransactionDump, Integer> {
    List<TransactionDump> findByPurchDateBetween(Date firstDate, Date secondDate);
    List<TransactionDump> findByTransTypeAndProductId(String transType, Integer productId);

}
