package com.kim.student.controller;


import com.kim.student.domain.Student;
import com.kim.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sutdentfinal")
@RequiredArgsConstructor
public class StudentRestController {
    private final StudentService studentService;
    @GetMapping
    public List<Student> list(){
        return studentService.getAllStudents();
    }
//    단건조회
    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

//    등록 -> 만들기 : post
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }
//    수정 :put
    @PutMapping
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);

    }
//    삭제 delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
