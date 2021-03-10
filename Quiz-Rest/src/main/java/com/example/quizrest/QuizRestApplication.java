package com.example.quizrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EntityScan(basePackages = { "Entities" })
@Configuration
@EnableJpaRepositories(basePackages ={"DAO","DAOImpl"})
@EnableSwagger2
public class QuizRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizRestApplication.class, args);

	}

}
