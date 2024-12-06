package com.ozerin.controllers;

import com.ozerin.entities.Client;
import com.ozerin.entities.CreditApplication;
import com.ozerin.entities.CreditContract;
import com.ozerin.services.ClientService;
import com.ozerin.services.CreditApplicationService;
import com.ozerin.services.CreditContractService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CreditApplicationController {

    @Autowired
    private CreditApplicationService creditApplicationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CreditContractService creditContractService;

    @GetMapping("/")
    public String showMainPage(){
        return "mainPage";
    }

    // Показать форму для новой заявки
    @GetMapping("/newApplication")
    public String showNewApplicationForm() {
        return "newApplication";
    }
    @PostMapping("/submitApplication")
    public String submitApplication(@ModelAttribute CreditApplication application, Model model) {
        Client client = clientService.getByFullNameOrPassportDataOrPhone(application.getClient().getPassportData());
        if (client == null){
            clientService.saveClient(application.getClient());
        } else {
            client.setPhone(application.getClient().getPhone());
            client.setAddress(application.getClient().getAddress());
            client.setMaritalStatus(application.getClient().getMaritalStatus());
            clientService.saveClient(client);
            application.setClient(client);
        }
        creditApplicationService.saveCreditApplication(application);
        creditContractService.saveCreditContract(new CreditContract(application, null, null));
        return "redirect:/clientsList";  // Перенаправление на список клиентов

    }
    @GetMapping("/applications")
    public String showApplications(@RequestParam(value = "status", required = false) String status,Model model){
        List<CreditApplication> applications;
        if (status == null || status.isEmpty()) {
            applications = creditApplicationService.getCreditApplications();
        } else {
            applications = creditApplicationService.getByStatus(status);
        }
        model.addAttribute("applications", applications);
        return "applications";
    }
}
