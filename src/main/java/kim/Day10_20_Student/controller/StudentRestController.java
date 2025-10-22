package kim.controller.Day10_20_Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kim.domain.Day10_20_Student.Student;
import kim.service.Day10_20_Student.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 학생 관리 REST API 컨트롤러 (Day10_20)
 *
 * 기능:
 * - 학생 목록 조회
 * - MyBatis를 통한 데이터베이스 연동
 *
 * 아키텍처:
 * - Controller (요청/응답 처리)
 *   └─ Service (비즈니스 로직)
 *      └─ Mapper (데이터베이스 접근)
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

	private final StudentService studentService;

	/**
	 * 학생 목록 조회
	 *
	 * @return 학생 목록
	 */
	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudent();
	}

}