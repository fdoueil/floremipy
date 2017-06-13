package edd.floremipy;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloreMipyApplication {
	
	public static Date startDate=new Date();

	public static void main(String[] args) {
		SpringApplication.run(FloreMipyApplication.class, args);
	}

}
