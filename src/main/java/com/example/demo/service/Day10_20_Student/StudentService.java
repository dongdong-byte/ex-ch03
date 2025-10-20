package com.example.kim.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kim.domain.Student;
import com.example.kim.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

//	public List<Student> getAllStudent() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public List<Student> getAllStudent() {
//		
//		List<Student> students = new ArrayList<>();
//		
//		students.add(new Student() {{setId(1L); setName("홍길동");}});	
//students.add(new Student() {{setId(2L); setname("이몽룡");}});
//students.add(new Student() {{setId(3L); setname("성춘향");}});
//		return students;
//	}

// 왜인지 오류가 남

//public List<Student> getAllStudent() {
////	DB연결전에 테스트
//	List<Student> students = new ArrayList<>();
//	students.add(new Student() {{setId(1L); setName("홍길동");}});
//	students.add(new Student() {{setId(2L); setName("이몽룡");}});
//	students.add(new Student() {{setId(3L); setName("성춘향");}});
//	return students;
//}
	
	
//	 public List<Student> getAllStudent() {
//	        // 방법 1: Builder 패턴 (Lombok @Builder 추가 필요)
//	        return List.of(
//	            Student.builder().id(1L).name("홍길동").build(),
//	            Student.builder().id(2L).name("이몽룡").build(),
//	            Student.builder().id(3L).name("성춘향").build()
//	        );
//	    }
////	
	

//	 public List<Student> getAllStudent() {
//		 return List.of(
//		            Student.builder().id(1L).name("홍길동").build(),
//		            Student.builder().id(2L).name("이몽룡").build(),
//		            Student.builder().id(3L).name("성춘향").build()
//		        );
//	 }
	
	private final StudentMapper studentMapper;
	
	public List<Student> getAllStudent(){
		return studentMapper.findAll();
		
		
	}
	
}
