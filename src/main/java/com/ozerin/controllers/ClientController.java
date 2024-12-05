package com.ozerin.controllers;

import com.ozerin.entities.CreditApplication;
import com.ozerin.entities.CreditContract;
import com.ozerin.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/clientsList")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clientsList";
    }
    @GetMapping("/searchClient")
    public String clientSearch(@RequestParam(value = "query",  required = false) String query, Model model){
        if (query != null && !query.trim().isEmpty()) {
            model.addAttribute("client", clientService.getByFullNameOrPassportDataOrPhone(query));
        }
        return "searchClient";
    }

}
