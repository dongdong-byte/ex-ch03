package kim.controller.Day10_21_Student02;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kim.domain.Day10_21_Student02.Student02;
import kim.service.Day10_21_Student02.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 학생 관리 REST API 컨트롤러 (Day10_21)
 *
 * 기능:
 * - 학생 목록 조회 (GET)
 * - 학생 상세 조회 (GET /{id})
 * - 학생 생성 (POST)
 * - 학생 수정 (PUT /{id})
 * - 학생 삭제 (DELETE /{id})
 *
 * 특징:
 * - ResponseEntity를 사용한 HTTP 상태 코드 반환
 * - MyBatis를 통한 완전한 CRUD 연산
 * - Slf4j 로깅
 */
@RestController
@RequestMapping("/api/student02")
@RequiredArgsConstructor
public class StudentRestContorller02 {

	private final StudentService studentService;

	/**
	 * 학생 목록 조회
	 *
	 * @return 모든 학생 목록
	 */
	@GetMapping
	public List<Student02> list() {
		return studentService.getAllStudents();
	}

	/**
	 * 학생 상세 조회
	 *
	 * @param id 학생 ID
	 * @return 학생 정보 또는 404 응답
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Student02> detail(@PathVariable Long id) {
		Student02 student = studentService.getStudents(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student);
	}

	/**
	 * 학생 생성
	 *
	 * @param student 학생 정보
	 * @return 생성된 학생 정보
	 */
	@PostMapping
	public ResponseEntity<Student02> create(@RequestBody Student02 student) {
		studentService.createStudent(student);
		return ResponseEntity.ok(student);
	}

	/**
	 * 학생 정보 수정
	 *
	 * @param id 학생 ID
	 * @param student 수정할 학생 정보
	 * @return 수정된 학생 정보
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Student02> update(
		@PathVariable Long id,
		@RequestBody Student02 student) {
		student.setId(id);
		studentService.updateStudent(student);
		return ResponseEntity.ok(student);
	}

	/**
	 * 학생 삭제
	 *
	 * @param id 학생 ID
	 * @return 204 No Content 응답
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}

}