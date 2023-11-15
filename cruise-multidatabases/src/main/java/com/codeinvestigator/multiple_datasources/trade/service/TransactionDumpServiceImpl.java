package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.trade.TransactionDump;
import com.codeinvestigator.multiple_datasources.trade.repository.TransactionDumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class TransactionDumpServiceImpl implements  TransactionDumpService {

    @Autowired
    TransactionDumpRepository transactionDumpRepository;

    @Override
    public TransactionDump saveTransactionDump(TransactionDump transactionDump) {
        return transactionDumpRepository.save(transactionDump);
    }

    @Override
    public List<TransactionDump> getTransactionDumps() {
        return (List<TransactionDump>) transactionDumpRepository.findAll();
    }

    @Override
    public List<TransactionDump> getTransactionDumpsBetweenDates(Date firstDate, Date secondDate, String transTypeParam) {

        List<TransactionDump> transactionsBetweenDates = transactionDumpRepository.findByPurchDateBetween(firstDate, secondDate);
        List<TransactionDump> transactions = transactionDumpRepository.findByPurchDateBetween(firstDate, secondDate);

        if (transTypeParam.equalsIgnoreCase("buy") || transTypeParam.equalsIgnoreCase("sell") || transTypeParam.equalsIgnoreCase("all")) {
            if (transTypeParam.equalsIgnoreCase("buy")) {
                transactions.clear();
                for (TransactionDump td : transactionsBetweenDates) {
                    if (td.getTransType().equalsIgnoreCase("buy")) {
                        transactions.add(td);
                    }
                }
            }

            if (transTypeParam.equalsIgnoreCase("sell")) {
                transactions.clear();
                for (TransactionDump td2 : transactionsBetweenDates) {
                    if (td2.getTransType().equalsIgnoreCase("sell")) {
                        transactions.add(td2);
                    }
                }
            }

            if (transTypeParam.equalsIgnoreCase("all")) {
                transactions.clear();
                transactions.addAll(transactionsBetweenDates);
            }

        } else {
            throw new IllegalArgumentException("transTypeParam must be either 'buy', 'sell' or 'all'");
        }

            return transactions;

    }

    @Override
    public void deleteTransactionDump(Integer id){
        transactionDumpRepository.deleteById(id);
    }

    @Override
    public TransactionDump getTransactionDumpById(Integer id){
        return transactionDumpRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


}
