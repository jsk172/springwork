package com.khit.todoweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{

	private TodoMapper todoMapper;
	private ModelMapper modelMapper;

	@Override
	public void insert(TodoDTO todoDTO) {
		//DTO를 VO로 변환 -> DB에 데이터를 저장
		//1. 모둘(ModelMapper)을 사용안한경우
		/*
		TodoVO todoVO = TodoVO.builder()
				.title(todoDTO.getTitle())
				.writer(todoDTO.getWriter())
				.build();
		*/
		
		//2. 모듈(modelMapper)를 사용
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		todoMapper.insert(todoVO);
	}

	@Override
	public List<TodoDTO> findAll() {
		//vo를 DTO로 변환(db -> 브라우저 화면)
		List<TodoVO> voList = todoMapper.findAll();
		
		//vo리스트를 dto로 저장하고 반환함.
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		return dtoList;
	}

}
