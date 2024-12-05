package com.ozerin.controllers;

import com.ozerin.services.CreditContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreditContractController {

    @Autowired
    private CreditContractService creditContractService;

    @GetMapping("/signedContracts")
    public String showSignedContracts(Model model){
        model.addAttribute("signedContracts", creditContractService.getSignedCreditContracts());
        return "signedContracts";
    }
}
