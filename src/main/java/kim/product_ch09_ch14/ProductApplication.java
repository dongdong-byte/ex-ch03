package kim.product_ch09_ch14;

import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

//     자바가 가지고 있는 리플렉션 api를 사용한것
@Bean
public ModelMapper modelMapper(){
	ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().
            setFieldMatchingEnabled(true).
            setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    return  modelMapper;

}
@Bean
    public ApplicationRunner runner(DataSource dataSource) {
        return args -> {
//             이부분에 실행할 코드를 넣으면된다
            Connection connection =dataSource.getConnection();
        };
}
}
