package edd.floremipy;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FloreMipyApplication {

	static final Date startDate=new Date();

	public static void main(String[] args) {
		SpringApplication.run(FloreMipyApplication.class, args);
	}

}
