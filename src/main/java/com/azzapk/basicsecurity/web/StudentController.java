package com.azzapk.basicsecurity.web;

import com.azzapk.basicsecurity.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student("student1", "Azza Putra"),
            new Student("student2", "Putra Kusuma"),
            new Student("student3", "Kusuma Azza")
    );

    @GetMapping("/{code}")
    public Student find(@PathVariable String code){
        return STUDENTS.stream()
                .filter(student -> code.equals(student.getCode()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student "+code+" does not exist"));
    }
}
