package com.ozerin.repositories;

import com.ozerin.entities.CreditContract;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditContractRepositoryImpl implements CreditContractRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public CreditContract save(CreditContract creditContract) {
        Session session = sessionFactory.getCurrentSession();
        if (creditContract.getId() == null){
            session.persist(creditContract);
        }else {
            session.merge(creditContract);
        }
        return creditContract;
    }

    public List<CreditContract> findSignedContracts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditContract where signatureStatus = 'Подписан'").getResultList();
    }
}
