package kim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Spring Boot 애플리케이션 메인 클래스
 *
 * 설정 정보:
 * - JPA 자동설정 제외 (MyBatis 및 순수 Java 기반 애플리케이션)
 * - 포트: 8090 (application.yml 참조)
 */
@SpringBootApplication(exclude = {
    HibernateJpaAutoConfiguration.class  // JPA 자동설정 제외
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
