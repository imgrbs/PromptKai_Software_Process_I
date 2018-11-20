package promptkai.sit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import promptkai.sit.AuthService.FacebookAuthFilter;

@SpringBootApplication
@CrossOrigin("*")
public class SitApplication {

	@Bean
	public FilterRegistrationBean<FacebookAuthFilter> loggingFilter(){
		FilterRegistrationBean<FacebookAuthFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new FacebookAuthFilter());
		registrationBean.addUrlPatterns("/payments/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SitApplication.class, args);
	}
}
