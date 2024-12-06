package com.ozerin.services;

import com.ozerin.entities.CreditContract;

import java.util.List;

public interface CreditContractService {
    CreditContract saveCreditContract(CreditContract creditContract);
    List<CreditContract> getSignedCreditContracts();
    CreditContract getById(Long id);
    List<CreditContract> getByStatus(String status);
    List<CreditContract> getAll();
    void signCreditContract(Long id);
}
