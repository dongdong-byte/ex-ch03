package kim.service.Day10_20_Student;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.domain.Day10_20_Student.Student;
import kim.mapper.Day10_20_Student.StudentMapper;
import lombok.RequiredArgsConstructor;

/**
 * 학생 서비스 (Day10_20)
 *
 * 기능:
 * - 학생 목록 조회
 * - 데이터베이스와의 상호작용 처리
 *
 * 특징:
 * - @Transactional(readOnly = true): 읽기 전용 트랜잭션
 * - MyBatis Mapper를 통한 데이터 접근
 */
@Service("studentServiceDay1020")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	/**
	 * 전체 학생 목록 조회
	 *
	 * @return 학생 목록
	 */
	public List<Student> getAllStudent() {
		return studentMapper.findAll();
	}

}