package Business.Tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusinessTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessTourApplication.class, args);
	}
}
