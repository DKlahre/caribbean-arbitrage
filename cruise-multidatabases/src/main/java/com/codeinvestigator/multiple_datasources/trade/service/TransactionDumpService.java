package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.trade.TransactionDump;
import java.util.Date;
import java.util.List;

public interface TransactionDumpService {

    TransactionDump saveTransactionDump(TransactionDump transactionDump);

    List<TransactionDump> getTransactionDumps();

    List<TransactionDump> getTransactionDumpsBetweenDates(Date firstDate, Date secondDate, String transType);

    void deleteTransactionDump(Integer id);

    TransactionDump getTransactionDumpById(Integer id);


}
