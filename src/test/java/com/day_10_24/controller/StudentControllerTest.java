package com.kim.student.controller;


import com.kim.student.domain.Student;
import com.kim.student.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static javax.swing.UIManager.get;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.RequestBuilder;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @MockitoBean
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("학생 목록페이지 조회 테스트")
    void  testList() throws Exception{
        given(studentService.getAllStudents())
                .willReturn(List.of(new Student(1L,"테스트이름","test@test.com",99,null,null)));
//     when &Then

        mockMvc.perform((RequestBuilder) get("/studentfinal"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentfinal/list"))
                .andExpect(model().attributeExists("student"));


    }
    @Test
    @DisplayName("2️⃣ 학생 등록 폼 페이지 이동")
    void testCreateForm() throws Exception {
        mockMvc.perform((RequestBuilder) get("/studentfinal/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentfinal/form"))
                .andExpect(model().attributeExists("student"));
    }

    @Test
    @DisplayName("3️⃣ 학생 등록 처리 (신규)")
    void testCreateStudent() throws Exception {
        Student newStudent = new Student(null, "이순신", "lee@test.com", 30, null, null);
        doNothing().when(studentService).createStudent(ArgumentMatchers.any(Student.class));

        mockMvc.perform(post("/studentfinal")
                        .param("name", newStudent.getName())
                        .param("email", newStudent.getEmail())
                        .param("age", String.valueOf(newStudent.getAge())))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/studentfinal"));
    }

    @Test
    @DisplayName("4️⃣ 학생 수정 폼 이동")
    void testEditForm() throws Exception {
        Long id = 1L;
        given(studentService.getStudentById(id))
                .willReturn(new Student(id, "홍길동", "hong@test.com", 22, null, null));

        mockMvc.perform(get("/studentfinal/{id}/edit", id))
                .andExpect(status().isOk())
                .andExpect(view().name("studentfinal/form"))
                .andExpect(model().attributeExists("student"));
    }

    @Test
    @DisplayName("5️⃣ 학생 수정 처리")
    void testUpdateStudent() throws Exception {
        Student updatedStudent = new Student(1L, "홍길동", "hong@test.com", 26, null, null);
        doNothing().when(studentService).updateStudent(ArgumentMatchers.any(Student.class));

        mockMvc.perform(post("/studentfinal")
                        .param("id", String.valueOf(updatedStudent.getId()))
                        .param("name", updatedStudent.getName())
                        .param("email", updatedStudent.getEmail())
                        .param("age", String.valueOf(updatedStudent.getAge())))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/studentfinal"));
    }

    @Test
    @DisplayName("6️⃣ 학생 삭제 처리")
    void testDeleteStudent() throws Exception {
        Long id = 1L;
        doNothing().when(studentService).deleteStudentById(id);

        mockMvc.perform(post("/studentfinal/{id}/delete", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/studentfinal"));
    }

}
