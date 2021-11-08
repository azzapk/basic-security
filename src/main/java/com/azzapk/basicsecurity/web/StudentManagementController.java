package com.azzapk.basicsecurity.web;

import com.azzapk.basicsecurity.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/student")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student("student1", "Azza Putra"),
            new Student("student2", "Putra Kusuma"),
            new Student("student3", "Kusuma Azza")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> findAll(){
        System.out.println("Get All Student");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void create(@RequestBody Student student){
        System.out.println("Add New Student");
        System.out.println(student);
    }

    @PatchMapping("/{code}")
    @PreAuthorize("hasAuthority('student:write')")
    public void update(@PathVariable String code,@RequestBody Student student){
        System.out.println("Updated Student "+ code);
        System.out.println(code +" "+ student);
    }

    @DeleteMapping("/{code}")
    @PreAuthorize("hasAuthority('student:write')")
    public void delete(@PathVariable String code){
        System.out.println("Deleted Student "+ code);
        System.out.println(code);
    }
}
