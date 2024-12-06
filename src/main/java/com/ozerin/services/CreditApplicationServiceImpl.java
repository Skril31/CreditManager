package com.ozerin.services;

import com.ozerin.entities.CreditApplication;
import com.ozerin.repositories.CreditApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService{
    @Autowired
    private CreditApplicationRepository creditApplicationRepository;
    @Transactional
    public CreditApplication saveCreditApplication(CreditApplication creditApplication) {
        creditApplication.setStatus(Math.random() > 0.5 ? "Одобрен" : "Не одобрен");
        if (creditApplication.getStatus().equals("Одобрен")){
            creditApplication.setApprovedAmount(creditApplication.getDesiredAmount().multiply(new BigDecimal(0.8)));
            creditApplication.setPaymentTerm((int) (Math.random() * 12 + 1) * 30);
        }
        return creditApplicationRepository.save(creditApplication);
    }

    @Transactional
    public List<CreditApplication> getCreditApplications() {
        return creditApplicationRepository.findAll();
    }

    @Transactional
    public List<CreditApplication> getByStatus(String status) {
        return creditApplicationRepository.findByStatus(status);
    }
}
