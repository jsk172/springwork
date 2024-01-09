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
	//필드
	private int page = 1;
	private int size = 10; //페이지당 게시글 수
	
	private String[] types;   //검색 유형
	private String keyword; //검색어
	
	public int getSkip() { //skip
		return (page-1) * 10; //1p - 0, 2p - 10
	}
}
