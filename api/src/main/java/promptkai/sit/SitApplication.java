package promptkai.sit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class SitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitApplication.class, args);
	}
}
