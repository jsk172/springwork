package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //������ ����(new �Ѱſ� ����)
@ToString
@Component
public class Company {
	//�ʵ�
	private Employee employee;
}
