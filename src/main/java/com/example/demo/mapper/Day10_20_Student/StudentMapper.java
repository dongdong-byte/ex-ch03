package com.example.kim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.kim.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();

}
