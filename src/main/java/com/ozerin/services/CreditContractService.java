package com.ozerin.services;

import com.ozerin.entities.CreditContract;

import java.util.List;

public interface CreditContractService {
    CreditContract saveCreditContract(CreditContract creditContract);
    List<CreditContract> getSignedCreditContracts();
}
