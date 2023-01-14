package unical.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class VinotequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinotequeApplication.class, args);
	}

}
