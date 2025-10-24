package com.kim.student.service;

import com.kim.student.domain.Student;
import com.kim.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private  final StudentMapper studentMapper ;

//    1.전체 조회
    public List<Student> getAllStudents(){
        log.debug("전체 학생 조회");
        return studentMapper.findAll();
    }
//    2.단건 조회
    public Student getStudentById(Long id){
        log.debug("학생조회 - Id : {}", id);
        Student student = studentMapper.findById(id);
        if(student == null){
            throw new IllegalArgumentException("존재하지 않는 학생입니다. ID :" + id);

        }
        return student;
    }
//    3.등록->create
    @Transactional
    public  void  createStudent(Student student){
        log.info("학생 등록 시작 -Name : {}", student.getName());
//       필드 검증
        validateRequiredFields(student);
//        데이터 형식 검증
        validateDataFormat(student);
//        이메일 중복 체크(xml에 findByEmail필요)
//      ===========
//        데이터 가공
        student.setName(student.getName().trim());
        student.setEmail(student.getEmail().trim());

        studentMapper.create(student);
        log.info("학생 등록 완료 -ID : {} , Name : {}" ,student.getId(),student.getName());
    }
//    4.수정->update
    @Transactional
    public void updateStudent(Student student){
        log.info("학생 수정 시작 -ID : {}", student.getId());
//        존재 여부 확인
        Student existing = studentMapper.findById(student.getId());
        if(existing == null){
            throw new IllegalArgumentException("존재하지 않는 학생입니다. ID:" +student.getId());


        }
//        필수 필드 검증
        validateRequiredFields(student);
//        데이터 형식 검증
        validateDataFormat(student);
//        수정 마무리
        studentMapper.update(student);
        log.info("학생 수정  완료용 -ID : {}", student.getId());
    }
//삭제
    @Transactional
    public void deleteStudentById(Long id){
        log.info("학생 삭제 시작 -ID : {}", id);
//        존재 여부 확인
        Student existing = studentMapper.findById(id);
        if(existing == null){
            throw  new IllegalArgumentException("존재하지 않는 학생입니다. ID:" +id);
        }
//        삭제 마무리
        studentMapper.delete(id);
        log.info("학생 삭제 완룡용용 -ID : {}", id);

    }





//=====검증 메서드들======
    private void validateRequiredFields(Student student) {
        if(student.getName() == null || student.getName().trim().isEmpty()){
            throw new IllegalArgumentException("이름은 필수 입니다");
        }
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()){

            throw  new IllegalArgumentException("이메일은 필수 입니다");
        }
        if(student.getAge() == null){
            throw  new IllegalArgumentException("나이는 필수 입니다");
        }

    }

    private void validateDataFormat(Student student) {
//        이메일 형식 검증
        String emalRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if(!student.getEmail().matches(emalRegex)){

            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }
//        이름 길이 검증
        if(student.getName().length()>50){
            throw new IllegalArgumentException("이름은 50자를 초과할 수 없습니다.");
        }
//        나이 범위 검증
        if(student.getAge()<0 || student.getAge()>160){
            throw new IllegalArgumentException("나이는 0~160 사이여야 합니다.");
        }

    }

}
