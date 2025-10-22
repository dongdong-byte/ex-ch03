package kim.day10_21_Student02.service;


import kim.day10_21_Student02.domain.Student02;
import kim.day10_21_Student02.mapper.StudentMapper02;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("studentServiceDay1021")
@RequiredArgsConstructor
@Transactional
public class StudentService02 {

//     학원 방식=> 기본적인 데이터 추가 방법
//    public List<Student> getAllStudents(){
//    롬복이 사용안될때 Dependency Injection-> 전통방식으로 해야함
//    @Autowired
//    StudentService studentService;

//    Dependency Injection 방법2-> 생성자에 선언


//    Dependency Injection 방법3-> 롬복에 사용
//    @RequiredArgsConstructor
//    public  class  StudentRestContorller{}


//    학원방식
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(){{setId(1L);setName("홍길동");}});
//        students.add(new Student(){{setId(2L);setName("이몽룡");}});
//        students.add(new Student(){{setId(3L);setName("성춘향");}});
//


// 더 많은 데이터를 한번에 넣는 방법
//        return Stream.of(
//                new Student(1L,"홍길동"),
//                new Student(2L,"이몽룡"),
//                new Student(3L,"성춘향")
//
//
//
//        ).toList();


//    }

//    ==========================
//    가변리스트 (수정이 가능)

//    private final List<Student> students = new ArrayList<>();
//    생성자에서 초기화
//    방법1
//    public  StudentService(){
//        students.add(new Student(1L,"홍길동"));
//                students.add(new Student(2L,"이몽룡"));
//                students.add(new Student(3L,"성춘향"));
//
//    }
//    방법2:Arrays.asList()-> 가장 추천

//    쿼리를 가져옴 -> 트랜잭션

    private final StudentMapper02 studentMapper;
//    public StudentService() {
//        students = new ArrayList<>(Arrays.asList(
//                new Student(1L,"홍길동"),
//                new Student(2L,"이몽룡"),
//                new Student(3L,"성충향")
//
//
//        )
//
//        );
//    }


//    public List<Student> getAllStudents(){
//        return students;
//    }
public Student02 getStudents(Long id){
    return studentMapper.findById(id);
}

    public List<Student02> getAllStudents(){

        return studentMapper.findAll();
    }

    @Transactional
    public void createStudent(Student02 student) {
        studentMapper.insert(student);
        log.info("학생 생성 : Student = {}", student);
    }
    @Transactional
    public void updateStudent(Student02 student) {
        studentMapper.update(student);
        log.info("학생 수정 : Student = {}", student);
    }
    @Transactional
    public void deleteStudent(Long id) {
        studentMapper.delete(id);
        log.info("학생 삭제 : ID = {}", id);
    }


//    나중에 추가/ 삭제 메서드를 만들수가 있음
//public void  addStudent(Student student){
//    students.add(student);
//}

}
