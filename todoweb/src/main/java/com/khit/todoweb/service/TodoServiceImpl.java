package com.khit.todoweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
 
@Slf4j
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
		
		//dto�� ��ȯ�ؼ� ��ȯ�� ��
		/*
		List<TodoDTO> dtoList = new ArrayList<>();
		for(TodoVO todoVO : voList) {
			//vo -> dto
			TodoDTO todoDTO = TodoDTO.builder()
					.tno(todoVO.getTno())
					.title(todoVO.getTitle())
					.writer(todoVO.getWriter())
					.build();
			dtoList.add(todoDTO);
		}*/
		
		//vo����Ʈ�� dto�� �����ϰ� ��ȯ��.
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		
		return dtoList;
	}

	/*�󼼺���
	@Override
	public TodoDTO detail(TodoDTO todoDTO) {
		TodoVO todoVO = TodoVO.builder()
				.tno(todoDTO.getTno())
				.build();
		log.info("" + todoDTO);
		log.info("" + todoVO);
		TodoVO VO = modelMapper.map(todoDTO, TodoVO.class);
		TodoDTO dto = modelMapper.map(todoMapper.detail(todoVO), TodoDTO.class);
		return dto;
	}*/

	//�󼼺���
	@Override
	public TodoDTO findById(Long tno) {
		//vo�� �����ͼ� DTO ��ȯ
		TodoVO todoVO = todoMapper.findById(tno);
		/*TodoDTO todoDTO = TodoDTO.builder()
				.tno(todoVO.getTno())
				.title(todoVO.getTitle())
				.writer(todoVO.getWriter())
				.build();*/
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		
		
		return todoDTO;
	}

	@Override
	public void update(TodoDTO todoDTO) {
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		todoMapper.update(todoVO);
	}

	@Override
	public void delete(Long tno) {
		todoMapper.delete(tno);
	}

	@Override
	public PageResponseDTO<TodoDTO> pagingList(PageRequestDTO pageRequestDTO) {
		//db���� volist ��������
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		//voList�� dtoList�� ��ȯ
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		//��ü ������ ���� ������
		int total = todoMapper.todoCount();
		
		PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
				.dtoList(dtoList)
				.total(total)
				.pageRequestDTO(pageRequestDTO)
				.build();
		return pageResponseDTO;
	}

}
