package com.khit.todoweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRequestDTO {
	//�ʵ�
	private int page = 1;
	private int size = 10; //�������� �Խñ� ��
	
	private String[] types;   //�˻� ����
	private String keyword; //�˻���
	
	public int getSkip() { //skip
		return (page-1) * 10; //1p - 0, 2p - 10
	}
}
