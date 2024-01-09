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
		
		//dto로 변환해서 반환해 줌
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
		
		//vo리스트를 dto로 저장하고 반환함.
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		
		return dtoList;
	}

	/*상세보기
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

	//상세보기
	@Override
	public TodoDTO findById(Long tno) {
		//vo를 가져와서 DTO 변환
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
		//db에서 volist 가져오기
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		//voList를 dtoList로 변환
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		//전체 데이터 개수 가져옴
		int total = todoMapper.todoCount();
		
		PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
				.dtoList(dtoList)
				.total(total)
				.pageRequestDTO(pageRequestDTO)
				.build();
		return pageResponseDTO;
	}

}
