package com.khit.todoweb.vo;

import java.sql.Timestamp;

import com.khit.todoweb.dto.TodoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //파라미터가 있는 생성자
@Data
public class TodoVO {
	//필드
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createDate;
}
