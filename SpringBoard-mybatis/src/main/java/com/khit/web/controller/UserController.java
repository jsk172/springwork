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
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.UserDTO;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//ȸ������ ������ ��û
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	//ȸ������ ó��
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO) {
		log.info("userDTO : " + userDTO);
		userService.insert(userDTO);
		return "redirect:/user/login"; // http://localhost:8080/
	}
	//ȸ�� ���
	@GetMapping("/")
	public String userList(Model model) {
		List<UserDTO> userDTOList = userService.findAll();
		model.addAttribute("userlist", userDTOList);
		return "/user/userlist";
	}
	//ȸ�� �󼼺���
	@GetMapping
	public String getUser(@RequestParam("id") long id, Model model) {
		UserDTO userDTO = userService.findById(id);
		model.addAttribute("user", userDTO);
		return "user/userdetail";
	}
	//�α��� ������
	@GetMapping("/login")
	public String loginForm() {
		
		return "user/login";
	}
	
	//�α��� ó��
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
		//�α��� ����, ����
		UserDTO loginUser = userService.login(userDTO);
		if(loginUser != null) {
			session.setAttribute("sessionId", userDTO.getUserId());
			return "redirect:/";
		}else {
			return "/user/login";
		}
	}
	
	//�α׾ƿ�
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//ȸ�� ����
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		//������ ȸ�� ��������(�����̸����� ��������)
		String userId = (String)session.getAttribute("sessionId");
		UserDTO userDTO = userService.findByUserId(userId);
		model.addAttribute("user", userDTO);
		return "/user/userupdate";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
		return "redirect:/user/update?id=" + userDTO.getId();
	}
	
	//ȸ�� ����
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id, HttpSession session) {
		userService.delete(id);
		session.invalidate();
		return "redirect:/user/";
	}
	//���̵� �ߺ� �˻�
	@PostMapping("/checkuserid")
	public @ResponseBody String userCheckUserId(@RequestParam("userId") String userId) {
		log.info(userId);
		return null;
	}
}
