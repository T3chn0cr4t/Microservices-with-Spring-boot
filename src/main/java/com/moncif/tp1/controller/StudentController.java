package com.moncif.tp1.controller;

import com.moncif.tp1.entities.formation;
import com.moncif.tp1.entities.student;
import com.moncif.tp1.reposotories.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-api")
public class StudentController {
    @Autowired
    private studentRepo studentRepo ;

    @GetMapping("/student/all")
    public List<student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/student/{id}")
    public student getStudentById(@PathVariable("id") Long studentID)
    {
        return studentRepo.findById(studentID).get();
    }

    @GetMapping("/student")
    public student getStudentById2(@RequestParam("id") Long studentID)
    {
        return studentRepo.findById(studentID).get();
    }

    @PostMapping("/student")
    public student createNewStudent(@RequestParam("idf") Long idf,@RequestBody student student)
    {
        student student1 = new student(student.getStudentID(),student.getName(),student.getDdn(),new formation(idf,"test",null)) ;
        return studentRepo.save(student1);
    }

    @PostMapping("/studentTp")
    public student createNewStudent(@RequestBody student student)
    {
        return studentRepo.save(student);
    }

    @PutMapping("/student/{id}")
    public student updateStudent(@PathVariable(value = "id") Long idStudent,
                               @RequestBody student student) {
        if (studentRepo.findById(idStudent).isPresent()) {
            student.setStudentID(idStudent);
            return studentRepo.save(student);
        }
        return null;
    }
    @PatchMapping("/student/{id}")
    public student updateStudentPatch(@PathVariable(value = "id") Long idStudent,
                                 @RequestBody student student) {
        if (studentRepo.findById(idStudent).isPresent()) {
            student.setStudentID(idStudent);
            return studentRepo.save(student);
        }
        return null;
    }
}
