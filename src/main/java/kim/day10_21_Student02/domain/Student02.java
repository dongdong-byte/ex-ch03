package kim.day10_21_Student02.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student02 {
   private long id;
   private String name;
   private String email;
   private Integer age;
   private LocalDateTime create_at;
   private LocalDateTime update_at;


}
