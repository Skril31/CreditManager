package com.ozerin.services;

import com.ozerin.entities.CreditContract;
import com.ozerin.repositories.CreditContractRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditContractServiceImpl implements CreditContractService{
    @Autowired
    private CreditContractRepository creditContractRepository;
    @Transactional
    public CreditContract saveCreditContract(CreditContract creditContract) {
        this.signCreditContract(creditContract);
        return creditContractRepository.save(creditContract);
    }
    @Transactional
    public CreditContract signCreditContract(CreditContract creditContract){
        if (creditContract.getCreditApplication().getStatus().equals("Одобрен")){
            creditContract.setSignatureStatus("Подписан");
            creditContract.setSignDate(LocalDate.now());
        }else {
            creditContract.setSignatureStatus("Не подписан");
        }
        return creditContract;
    }
    @Override
    @Transactional
    public List<CreditContract> getSignedCreditContracts() {
        return creditContractRepository.findSignedContracts();
    }
}
