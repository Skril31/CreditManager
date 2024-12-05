package com.ozerin.repositories;

import com.ozerin.entities.Client;
import com.ozerin.entities.CreditApplication;

import java.util.List;

public interface CreditApplicationRepository {
    CreditApplication save(CreditApplication creditApplication);
    List<CreditApplication> findAll();

}
