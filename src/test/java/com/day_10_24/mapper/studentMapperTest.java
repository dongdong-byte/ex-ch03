package com.kim.student.mapper;


import com.kim.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class studentMapperTest {

    @Autowired
    private StudentMapper mapper;
    @Test
    void testFindAll(){
        List<Student> students = mapper.findAll();
        System.out.println("학생수 : " +students.size() );


    }

    @Test
    void  testCreate(){
        Student student = new Student();
        student.setName("테스트이름");
        student.setEmail("test@test.com");
        student.setAge(100);

        mapper.create(student);
        System.out.println("생성된 ID :" + student.getId());
    }
}
