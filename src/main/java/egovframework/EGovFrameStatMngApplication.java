package egovframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EGovFrameStatMngApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGovFrameStatMngApplication.class, args);
	}

}
