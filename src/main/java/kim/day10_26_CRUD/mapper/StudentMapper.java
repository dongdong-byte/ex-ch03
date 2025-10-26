package kim.day10_26_CRUD.mapper;


import kim.day10_26_CRUD.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
//    Create Read(findAll,findById) Update Delete
    List<Student> findAll();
    Student findById(Long id);
    void create(Student student);
    void update(Student student);
    void delete(Long id);
}
