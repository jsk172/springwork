package com.khit.todoweb.mapper;


import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired
	private TodoMapper todoMapper;
	
	
	/*
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}*/
	/*
	@Test
	public void testInsert() {
		//데이터 1개 생성 - builder()

		TodoVO todoVO = TodoVO.builder()
				.title("잠자기")
				.writer("너")
				.build();
		
		todoMapper.insert(todoVO);
	}*/
	/*
	@Test
	public void testFindAll() {
		//db에 있는 데이터 추출하기
		List<TodoVO> todoList = todoMapper.findAll();
		
		for(TodoVO todo : todoList) {
			log.info(todo);
		}
	}*/
	/*
	@Test
	public void testFindById() {
		//db에서 1번 데이터 검색
		TodoVO todoVO = todoMapper.findById(1L);
	}*/
	/*
	@Test
	public void testPagingList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		List<TodoVO> todoList = todoMapper.pagingList(pageRequestDTO);
		for(TodoVO todo : todoList) {
			log.info(todoList);
		}
	}*/
	
	
	
	@Test
	public void testSelectSearch() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[]{"t","w"})
				.keyword("잠")
				.build();
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		for(TodoVO todoVO : voList) {
			log.info(todoVO);
		}
				
	}
	
}
