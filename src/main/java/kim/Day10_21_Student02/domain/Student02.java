package kim.domain.Day10_21_Student02;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student02 {
   private Long id;
   private String name;
   private String email;
   private Integer age;
   private LocalDateTime create_at;
   private LocalDateTime update_at;


}
