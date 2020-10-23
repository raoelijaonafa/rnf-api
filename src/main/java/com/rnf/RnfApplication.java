package com.rnf;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RnfApplication extends SpringBootServletInitializer{

	@PostConstruct
    public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(RnfApplication.class);
	 }
	public static void main(String[] args) {
		SpringApplication.run(RnfApplication.class, args);
	}

}
