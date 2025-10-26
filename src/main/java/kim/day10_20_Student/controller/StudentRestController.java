package kim.day10_20_Student.controller;

import org.springframework.web.bind.annotation.RestController;

import kim.day10_20_Student.service.StudentService;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import kim.day10_20_Student.domain.Student;
//controller-> 고객 센터 직원-> 고객 센터 직원이 사용자에 주문을 받습니다.
//고객센터 직원이 할일
//1.당신의 주문을 확인합니다("학생목록 주세요 "이란 상품 요청 접수)
//2.배송관리자(Service)에게 전달합니다.( Service님"학생목록" 이란 상품 배송 부탁드립니다.)
//3.상품이 도착하면 당신에게 포장해서 전달합니다.
import lombok.RequiredArgsConstructor;

//@RestController-> http요청을 받고 자동으로 json응답을 보내는 컨트롤러
@RestController("day1020StudentRestController")//저는 고객센터 직원입니다.

@RequestMapping("/api/students-v1")
//학생관련 주문을 받습니다.-> api/student에 학생 목록 올립니다.
//@RequiredArgsConstructor-> 생성자를 자동으로 만들어서 Service를 주입
//@RequiredArgsConstructor-> 롬복을 설치해야지만 사용할수 있는 이노테이션
@RequiredArgsConstructor
public class StudentRestController {
// 생성자를 위에서 작성해서 테스트 서버(가짜 서버를 만들수 있다)
//    가짜 서버를 만들려고 할때는 studentService 이 변수를 이용해 메서드 이름만 다르게 구성해도 된다.
//	final을 붙이는 이유 -> 휴대폰 배터러ㅣ를 한번끼우면 바꾸지 않겠다는 약속
//    final-> 한번 할당하면 변경불가
//    생성자에서 한번 받으면 끝!
//    중간에 null이 될수 없음 -> 안전!
//    RequiredArgsConstructor는 final필드만 생성자가 포함된다.
//    한번 주입받으면 평생 그객체만 사용되니까 멀티 스레드 환경에서도 안전
//    한개에 휴대폰도 다양한 배터리를 여러번 교체하면 휴대폰도 망가지고 배터리가 맞지 않을때 어떤 배터리가 맞는지 모르니까 처음부터 맞는 베터리를 일체형으로 설계한다.
    private final StudentService studentService;//    배송관리자 (service) 연결
//생성자를 굳이 안써도 lombok이 자동으로 만들어줌
	@GetMapping//    get->요청(주

    // 문 처리)
	public List<Student> list()
//    배송관리자에게 전달하고 결과를 받아서 고객에게 전달-> 일종에 창구
    {
//        return studentService 에서 getAllStudent 메서드 소환-> 학생 목록 소환하라.
		return studentService.getAllStudent();
	}

	
	
}
