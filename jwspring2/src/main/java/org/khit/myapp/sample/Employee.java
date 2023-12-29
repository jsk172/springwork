package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor //기본 생성자(매개변수가 없는 생성자)
@ToString
@Component  // =(@Controller, @Repository, @Service)의 부모
public class Employee {
	
}
