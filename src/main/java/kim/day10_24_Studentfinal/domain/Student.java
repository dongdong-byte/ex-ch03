package com.kim.student.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
