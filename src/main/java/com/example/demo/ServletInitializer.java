package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootMybatisApplication.class);
	}
	
//	SpringBootServletInitializer는 왜 사용하는것일까?
//	요약 
//	사용이유 : war 확장자로 배포할 경우 사용
//	https://adg0609.tistory.com/60

}
