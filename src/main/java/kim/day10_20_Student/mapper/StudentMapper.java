package kim.day10_20_Student.mapper;

import kim.day10_20_Student.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("studentMapperDay1020")  // 고유한 Bean 이름 지정
public interface StudentMapper {

	List<Student> findAll();

}
