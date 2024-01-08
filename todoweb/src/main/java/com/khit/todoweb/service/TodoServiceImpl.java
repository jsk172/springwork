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
		//DTO�� VO�� ��ȯ -> DB�� �����͸� ����
		//1. ���(ModelMapper)�� �����Ѱ��
		/*
		TodoVO todoVO = TodoVO.builder()
				.title(todoDTO.getTitle())
				.writer(todoDTO.getWriter())
				.build();
		*/
		
		//2. ���(modelMapper)�� ���
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		todoMapper.insert(todoVO);
	}

	@Override
	public List<TodoDTO> findAll() {
		//vo�� DTO�� ��ȯ(db -> ������ ȭ��)
		List<TodoVO> voList = todoMapper.findAll();
		
		//vo����Ʈ�� dto�� �����ϰ� ��ȯ��.
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		return dtoList;
	}

}
