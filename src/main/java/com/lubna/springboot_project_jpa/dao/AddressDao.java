package com.lubna.springboot_project_jpa.dao;

import com.lubna.springboot_project_jpa.entity.Address;
import com.lubna.springboot_project_jpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface AddressDao {

    Address persist(Address address);

    Optional<Address> findById(Integer id);

    Collection<Address> findAll();

    Address update(Address address);

    void remove(Integer id);
}
