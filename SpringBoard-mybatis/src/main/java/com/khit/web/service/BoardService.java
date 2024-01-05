package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;

public interface BoardService {

	void insert(BoardDTO boardDTO);

	List<BoardDTO> findAll();

	BoardDTO findById(Long id);

	void updateHit(Long id);

	void delete(Long id);

	void update(BoardDTO boardDTO);

	List<BoardDTO> pagingList(int page);

	PageDTO pagingParam(int page);

}
