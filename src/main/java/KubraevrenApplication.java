import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.springprojem.kubraevren.model"})
@EnableJpaRepositories(basePackages = {"com.springprojem.kubraevren.repository"})
@ComponentScan(basePackages = {"com.springprojem.kubraevren"})
public class KubraevrenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubraevrenApplication.class, args);
	}

}
