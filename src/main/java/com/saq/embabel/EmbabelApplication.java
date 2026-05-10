package com.saq.embabel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(BlogAgentProperties.class)
public class EmbabelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbabelApplication.class, args);
	}

}
