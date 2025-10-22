package kim.service.Day10_21_Student02;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.domain.Day10_21_Student02.Student02;
import kim.mapper.Day10_21_Student02.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 학생 서비스 (Day10_21)
 *
 * 기능:
 * - 학생 목록 조회
 * - 학생 상세 조회
 * - 학생 생성
 * - 학생 정보 수정
 * - 학생 삭제
 *
 * 특징:
 * - @Transactional: 모든 메서드에 트랜잭션 적용
 * - Slf4j 로깅
 * - MyBatis Mapper를 통한 CRUD 연산
 */
@Slf4j
@Service("studentServiceDay1021")
@RequiredArgsConstructor
@Transactional
public class StudentService {

	private final StudentMapper studentMapper;

	/**
	 * 특정 학생 조회
	 *
	 * @param id 학생 ID
	 * @return 학생 정보
	 */
	public Student02 getStudents(Long id) {
		return studentMapper.findById(id);
	}

	/**
	 * 전체 학생 목록 조회
	 *
	 * @return 학생 목록
	 */
	public List<Student02> getAllStudents() {
		return studentMapper.findAll();
	}

	/**
	 * 학생 생성
	 *
	 * @param student 학생 정보
	 */
	@Transactional
	public void createStudent(Student02 student) {
		studentMapper.insert(student);
		log.info("학생 생성 : Student = {}", student);
	}

	/**
	 * 학생 정보 수정
	 *
	 * @param student 학생 정보
	 */
	@Transactional
	public void updateStudent(Student02 student) {
		studentMapper.update(student);
		log.info("학생 수정 : Student = {}", student);
	}

	/**
	 * 학생 삭제
	 *
	 * @param id 학생 ID
	 */
	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
		log.info("학생 삭제 : ID = {}", id);
	}

}