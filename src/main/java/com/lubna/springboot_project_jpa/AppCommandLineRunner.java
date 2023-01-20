package com.lubna.springboot_project_jpa;

import com.lubna.springboot_project_jpa.dao.StudentDao;
import com.lubna.springboot_project_jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    StudentDao studentDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##### Test Lubna #####");
        Student lubna = studentDao.persist(new Student("Lubna", "Farheen", "lubna@gmail.com", LocalDate.parse("1993-08-01")));
    }
}
