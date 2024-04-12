package it.spkt.fashionecommercebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FashionEcommerceBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionEcommerceBeApplication.class, args);
	}

}
