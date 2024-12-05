package com.ozerin.repositories;

import com.ozerin.entities.CreditContract;

import java.util.List;

public interface CreditContractRepository {
    CreditContract save(CreditContract creditContract);
    List<CreditContract> findSignedContracts();
}
