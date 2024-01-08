package com.khit.todoweb.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //파라미터가 있는 생성자
@Data
public class TodoDTO {
	//필드
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createDate;
}
