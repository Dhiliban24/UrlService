package com.ctsproject.urlshortener;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages={"com.ctsproject"})
public class UrlshortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortenerApplication.class, args);
		System.out.println("URL Shortening service");
		
	}
	
	
}
