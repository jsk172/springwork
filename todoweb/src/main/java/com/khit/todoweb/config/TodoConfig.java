package com.khit.todoweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정파일로 만들어주는 어노테이션
@Configuration
public class TodoConfig {
	
	//ModelMapper를 Bean으로 등록함.
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
