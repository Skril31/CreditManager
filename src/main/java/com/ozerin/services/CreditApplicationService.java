package com.ozerin.services;

import com.ozerin.entities.CreditApplication;

import java.util.List;

public interface CreditApplicationService {
    CreditApplication saveCreditApplication(CreditApplication creditApplication);
    List<CreditApplication> getCreditApplications();
    List<CreditApplication> getByStatus(String status);
}
