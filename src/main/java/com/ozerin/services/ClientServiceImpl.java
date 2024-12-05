package com.ozerin.services;

import com.ozerin.entities.Client;
import com.ozerin.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client saveClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client getById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client getByFullNameOrPassportDataOrPhone(String query) {
        return clientRepository.findByFullNameOrPassportDataOrPhone(query);
    }
}
