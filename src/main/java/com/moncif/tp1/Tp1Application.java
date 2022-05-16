package com.moncif.tp1;

import com.moncif.tp1.entities.formation;
import com.moncif.tp1.entities.student;
import com.moncif.tp1.reposotories.formationRepo;
import com.moncif.tp1.reposotories.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication

public class Tp1Application implements CommandLineRunner {
    @Autowired
    studentRepo studentRepo;
    @Autowired
    formationRepo formationRepo;
    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args); }
    @Override
    public void run(String... args) throws Exception {
        formation f1 = new formation(null,"web",null) ;
        formation f2 = new formation(null,"AI",null) ;
        formationRepo.save(f1);
        formationRepo.save(f2);
        studentRepo.save(
                new student(null, "moncif", Date.valueOf("2001-01-13"),f1));
        studentRepo.save(
                new student(null, "mhammed", Date.valueOf("2000-06-20"),f2));

        student s1= studentRepo.findById(1L).get();
        s1.setName("ahmed");
        studentRepo.save(s1);

    }
}

