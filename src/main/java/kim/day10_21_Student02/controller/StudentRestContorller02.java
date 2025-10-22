package kim.day10_21_Student02.controller;


import kim.day10_21_Student02.domain.Student02;
import kim.day10_21_Student02.service.StudentService02;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/student02")
@RequiredArgsConstructor
public class StudentRestContorller02 {
    private final StudentService02 studentService;


    @GetMapping
    public List<Student02> list() {
        return studentService.getAllStudents();

    }
//    단건조회 :Get http://localhost:8080/api/student02/
    @GetMapping("/{id}")
    public ResponseEntity<Student02> detail(@PathVariable Long id){
        Student02 student = studentService.getStudents(id);
        if(student == null){
            return ResponseEntity.notFound().build();


        }
        return  ResponseEntity.ok(student);
    }

//    등록 -> 만들기 : Post http://localhost:8080/api/students
    @PostMapping
    public ResponseEntity<Student02> create(@RequestBody Student02 student){
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

//   수정 put
@PutMapping("/{id}")
public ResponseEntity<Student02> update(@PathVariable Long id, @RequestBody Student02 student){
    student.setId(id);
    studentService.updateStudent(student);

    return ResponseEntity.ok(student);
    }

// 삭제 delete
@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();

}
}




