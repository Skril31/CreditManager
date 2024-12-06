package com.ozerin.controllers;

import com.ozerin.entities.CreditContract;
import com.ozerin.services.CreditContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreditContractController {

    @Autowired
    private CreditContractService creditContractService;

    @GetMapping("/contracts")
    public String showSignedContracts(@RequestParam(value = "filter", required = false) String filter, Model model){
        List<CreditContract> contracts;
        if (filter == null || filter.isEmpty()) {
            contracts = creditContractService.getAll();
        } else {
            contracts = creditContractService.getByStatus(filter);
        }
        model.addAttribute("contracts", contracts);
        return "contracts";
    }
    @PostMapping("/contracts/sign")
    public String signContract(@RequestParam("contractId") Long id) {
        creditContractService.signCreditContract(id);
        return "redirect:/contracts";
    }
}
