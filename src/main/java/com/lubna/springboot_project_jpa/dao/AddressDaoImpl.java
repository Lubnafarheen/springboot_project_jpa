package com.lubna.springboot_project_jpa.dao;

import com.lubna.springboot_project_jpa.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Address persist(Address address) {
        entityManager.persist(address);
        return address;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Address> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Address.class, id));
/*
        return entityManager.createQuery("select a from Address a where a.id = :id")
                .setParameter("id", id).getResultStream().findFirst();*/
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Address> findAll() {
        return entityManager.createQuery("select a from Address a", Address.class).getResultList();
    }

    @Transactional
    @Override
    public Address update(Address address) {
        return entityManager.merge(address);
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        Address deleteAddress = entityManager.find(Address.class, id);
        entityManager.remove(deleteAddress);
    }
}
