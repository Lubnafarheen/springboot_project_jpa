package com.lubna.springboot_project_jpa.dao;


import com.lubna.springboot_project_jpa.entity.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class StudentDaoImplTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    StudentDaoImpl testObject;

    String amyId;
    String maryId;


    @BeforeEach
    public void setup() {
        Student amy = new Student("Amy", "Jackson", "amy@gmail.com", LocalDate.parse("1998-04-23"));
        Student mary = new Student("Mary", "Kom", "mary.kom@yahoo.com", LocalDate.parse("1990-06-13"));
        Student student1 = entityManager.persist(amy);
        Student student2 = entityManager.persist(mary);
        amyId = student1.getId();
        maryId = student2.getId();
    }
    @Test
    public void persist_Test(){
        Student jamy = new Student("Jamy", "Jackson", "jamy@gmail.com", LocalDate.parse("1993-04-23"));
        Student actual = testObject.persist(jamy);
        assertNotNull(actual);
        assertNotNull(actual.getId());
    }

}
