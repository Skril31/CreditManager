package com.ozerin.services;

import com.ozerin.entities.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getAllClients();
    Client getById(Long id);
    Client getByFullNameOrPassportDataOrPhone(String query);
    List<Client> getListByFullNameOrPassportDataOrPhone(String query);

}
