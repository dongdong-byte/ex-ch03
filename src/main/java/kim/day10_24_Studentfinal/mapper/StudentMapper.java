package com.kim.student.mapper;


import com.kim.student.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
//    CRUD
//    create
//    Read -> 1.전체 데이터 찾기=findAll ,2.개별 데이터 찾기=findByID
//    update
//    delete


    List<Student>findAll();
    Student findById(Long id);
    void  create(Student student);
    void  update(Student student);
    void  delete(Long id);

}
