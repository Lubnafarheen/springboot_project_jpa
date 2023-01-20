package com.lubna.springboot_project_jpa.dao;

import com.lubna.springboot_project_jpa.exception.DataNotFoundException;
import com.lubna.springboot_project_jpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

    Student persist(Student student);

    Optional<Student> findById(String id);

    Optional<Student> findByEmail(String email);

    Collection<Student> findByNameContains(String name);

    Collection<Student> findAll();

    Student update(Student student);

    void remove(String id) throws DataNotFoundException;
}
