package kim.day10_21_Student02.mapper;


import kim.day10_21_Student02.domain.Student02;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository("studentMapperDay1021")  // 고유한 Bean 이름 지정
public interface StudentMapper02 {
    List<Student02> findAll() ;
//    @Select("select  *from student where id = #{id}")
    Student02 findById(Long id);
@Insert("insert into testdb.student(name, email, age) VALUE\n" +
        "\n" +
        "(#{name},#{email},#{age});")
@Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Student02 student);

    void update(Student02 student);
//    @Update(
//            "update  student\n" +
//                    "        set  name= #{name},\n" +
//                    "        email = #{email},\n" +
//                    "        age = #{age},\n" +
//                    "        update_at =now()\n" +
//                    "        where id = #{id}\n"
//
//
//    )
//void update(Student student);
    void delete(Long id);
//    @Delete(" delete from student where id = #{id}")
//    void delete(Long id);
}
