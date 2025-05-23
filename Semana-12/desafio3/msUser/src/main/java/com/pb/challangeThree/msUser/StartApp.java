package com.pb.challangeThree.msUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StartApp {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

}
