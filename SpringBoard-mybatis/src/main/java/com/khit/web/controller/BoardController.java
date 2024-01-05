package com.khit.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor //생성자 주입
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO=" + boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/paging"; //pagelist.jsp
	}
	
	//글목록
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		return "board/pagelist";
	}
	
	//글목록(페이지처리)
	//@RequestParam(required=true/false) -> false는 필수가 아님
	@GetMapping("/paging")
	public String getPageList(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
		log.info("page=" + page);
		//페이지와 글 개수 구현
	 	List<BoardDTO> pagingList = boardService.pagingList(page);
	 	log.info("page=" + pagingList);
		
	 	model.addAttribute("boardList",pagingList);
	 	//화면 하단 구현
	 	PageDTO pageDTO = boardService.pagingParam(page);
	 	model.addAttribute("paging", pageDTO);
	 	
		return "/board/pagelist";
	}
	
	//글 상세보기
	@GetMapping
	public String getBoard(@RequestParam("id") Long id, Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		//조회수 증가
		boardService.updateHit(id);
		//글 상세보기
		BoardDTO boardDTO = boardService.findById(id);
		//댓글 목록
		List<ReplyDTO> replyDTOList = replyService.getReplyList(id);
		
		model.addAttribute("board", boardDTO);
		model.addAttribute("replyList", replyDTOList);
		model.addAttribute("page",page);
		
		
		return "/board/detail";
	}
	
	//글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	
	//게시글 수정페이지
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model model) {
		//수정할 게시글 가져오기
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/boardupdate";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		//수정해서 DTO로 다시 저장
		boardService.update(boardDTO);
		return "redirect:/board/update?id=" + boardDTO.getId();
	}
}
