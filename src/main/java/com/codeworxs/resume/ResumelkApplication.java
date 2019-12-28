package com.codeworxs.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.codeworxs.resume.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ResumelkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumelkApplication.class, args);
	}

}
