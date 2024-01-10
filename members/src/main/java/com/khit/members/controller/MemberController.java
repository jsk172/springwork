package com.khit.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	private MemberService memberService;
	//회원가입
	@GetMapping("/join")
	public String joinForm() {
		return "/member/join";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		
		log.info("memberDTO"+ memberDTO);
		memberService.insert(memberDTO);
		return "/member/login";
	}
	//로그인
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember != null) {
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			log.info("로그인 성공: " + memberDTO.getEmail());
			log.info("" + loginMember);
			return "index";
		}else {
			log.info("로그인 실패");
			return "/member/login";
		}
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	//수정
	@GetMapping("/update")
	public String updateForm(HttpSession session, Model model) {
		String email = (String)session.getAttribute("sessionEmail");
		MemberDTO memberDTO = memberService.findByEmail(email);
		model.addAttribute("member",memberDTO);
		return "/member/update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
		log.info(""+memberDTO);
		return "index";
	}
	//회원삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("email") String email, HttpSession session) {
		memberService.delete(email);
		session.invalidate();
		return "index";
	}
	
}
