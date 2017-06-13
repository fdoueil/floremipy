package edd.floremipy;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import edd.floremipy.JpaConfiguration;

@Import(JpaConfiguration.class)

@SpringBootApplication
public class FloreMipyApplication {
	
	public static Date startDate=new Date();

	public static void main(String[] args) {
		SpringApplication.run(FloreMipyApplication.class, args);
	}

}
