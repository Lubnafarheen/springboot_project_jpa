package com.lubna.springboot_project_jpa;

import com.lubna.springboot_project_jpa.dao.AddressDao;
import com.lubna.springboot_project_jpa.dao.StudentDao;
import com.lubna.springboot_project_jpa.entity.Address;
import com.lubna.springboot_project_jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    StudentDao studentDao;
    @Autowired
    AddressDao addressDao;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Address lubnaAddress = addressDao.persist(new Address("Stockholm", "Vandrarstigen", "16344"));
        Student lubna = new Student("Lubna","Farheen", "lubna@gmail.com", LocalDate.now());
        lubna.setAddress(lubnaAddress);
        Student lubnaFarheen = studentDao.persist(lubna);

        Address nusaybaAddress = addressDao.persist(new Address("Gothenberg", "street1", "14567"));
        Student nusayba = new Student("Nusayba", "Tanzeem", "nusi@gmail.com", LocalDate.now());
        nusayba.setAddress(nusaybaAddress);
        studentDao.persist(nusayba);

        System.out.println(studentDao.findAll());
    }
}
