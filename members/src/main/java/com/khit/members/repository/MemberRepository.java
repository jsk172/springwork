package com.khit.members.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.khit.members.dto.MemberDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class MemberRepository {
	
	private SqlSessionTemplate sql;
	
	public void insert(MemberDTO memberDTO) {
		sql.insert("Member.insert", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}
	
	public void update(MemberDTO memberDTO) {
		sql.update("Member.update", memberDTO);
	}

	public MemberDTO findByEmail(String email) {
		return sql.selectOne("Member.findByEmail", email);
	}

	public void delete(String email) {
		sql.delete("Member.delete",email);
	}

}
