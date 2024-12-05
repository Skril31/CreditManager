package com.ozerin.repositories;

import com.ozerin.entities.Client;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository{

    @Autowired
    private SessionFactory sessionFactory;
    public Client save(Client client){
        Session session = sessionFactory.getCurrentSession();
        if (client.getId() == null){
            session.persist(client);

        }
        else {
            session.merge(client);
        }
        return client;
    }

    public List<Client> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client ", Client.class).getResultList();
    }

    public Client findById(Long id){
        Session session = sessionFactory.getCurrentSession();
        return session.find(Client.class, id);
    }

    @Override
    public Client findByFullNameOrPassportDataOrPhone(String query) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from Client where fullName = :query or passportData = :query or phone = :query", Client.class).
                    setParameter("query", query).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
