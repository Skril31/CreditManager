package com.ozerin.repositories;

import com.ozerin.entities.Client;
import com.ozerin.entities.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditApplicationRepositoryImpl implements CreditApplicationRepository{

    @Autowired
    private SessionFactory sessionFactory;
    public CreditApplication save(CreditApplication creditApplication) {
        Session session = sessionFactory.getCurrentSession();
        if (creditApplication.getId() == null){
            session.persist(creditApplication);
        }
        else {
            session.merge(creditApplication);
        }
        return creditApplication;
    }

    public List<CreditApplication> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditApplication", CreditApplication.class).getResultList();
    }


}
