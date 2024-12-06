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
        creditContract.setSignatureStatus("Не подписан");
        return creditContractRepository.save(creditContract);
    }
    @Transactional
    public void signCreditContract(Long id){
        CreditContract contract = creditContractRepository.findById(id);
        if (contract == null){
            throw new IllegalArgumentException("Invalid contract ID: " + id);
        }
        if ("Не подписан".equals(contract.getSignatureStatus())) {
            contract.setSignatureStatus("Подписан");
            contract.setSignDate(java.time.LocalDate.now()); // Устанавливаем текущую дату подписания
            creditContractRepository.save(contract);
        }
    }
    @Override
    @Transactional
    public List<CreditContract> getSignedCreditContracts() {
        return creditContractRepository.findSignedContracts();
    }

    @Override
    @Transactional
    public List<CreditContract> getByStatus(String status) {
        return creditContractRepository.findBySignatureStatus(status);
    }

    @Override
    @Transactional
    public List<CreditContract> getAll() {
        return creditContractRepository.findAll();
    }

    @Override
    @Transactional
    public CreditContract getById(Long id) {
        return creditContractRepository.findById(id);
    }
}
