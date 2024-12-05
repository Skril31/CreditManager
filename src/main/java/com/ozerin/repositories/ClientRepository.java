package com.ozerin.repositories;

import com.ozerin.entities.Client;
import java.util.List;

public interface ClientRepository {
    Client save(Client client);
    List<Client> findAll();
    Client findById(Long id);
    Client findByFullNameOrPassportDataOrPhone(String query);

}
