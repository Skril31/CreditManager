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

    @Override
    public List<CreditContract> findBySignatureStatus(String status) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditContract where signatureStatus = :status", CreditContract.class).
                setParameter("status", status).getResultList();
    }

    @Override
    public List<CreditContract> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditContract", CreditContract.class).getResultList();
    }

    @Override
    public CreditContract findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(CreditContract.class, id);
    }
}
