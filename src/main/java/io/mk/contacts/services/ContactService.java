package io.mk.contacts.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ContactService {
    @PersistenceContext
    private EntityManager em;

    public void findCompany() {
        System.out.println("elo");
    }
}
