package com.fbedir;

import com.fbedir.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})})
public class InfraApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraApplication.class, args);
	}

}
