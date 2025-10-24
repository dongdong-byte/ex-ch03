package com.kim.student.controller;


import com.kim.student.domain.Student;
import com.kim.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/studentfinal")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
//    Create Read Update Delete

//    list 전체 학생목록 조회 ->Read
    @GetMapping
    public  String list(Model model){
        log.info("학생 목록 조회");
        model.addAttribute("student",studentService.getAllStudents());
        return "studentfinal/list";
    }

//    등록 폼 ->create
    @GetMapping("/new")
    public  String createForm(Model model){
        log.info("학생 등록 폼  요청");
        model.addAttribute("student",new Student());
        return "studentfinal/form";

    }


//    수정 폼->update
    @GetMapping("/{id}/edit")
    public  String editForm(@PathVariable Long id , Model model){
        log.info("학생 수정폼 - ID : {}" , id);
        Student student = studentService.getStudentById(id);
        if(student == null){
            log.warn("학생을 찾을수 없음 -ID :{}",id);
            return "redirect:/studentfinal";

        }
        model.addAttribute("student",student);
        return "studentfinal/form";

    }
//   등록 / 수정 처리
@PostMapping
public  String save(@ModelAttribute Student student){
//        null 체크 추가
    if(student.getId() == null || student.getId() == 0){
        log.info("학생등록 - ID : {}" , student.getName());
        studentService.createStudent(student);


    }else {
        log.info("학생수정 - ID : {}" , student.getId());
        studentService.updateStudent(student);
    }
        return "redirect:/studentfinal";
}
//삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        log.info("학생 삭제 - ID : {}" , id);
        studentService.deleteStudentById(id);
        return "redirect:/studentfinal";

    }

}
