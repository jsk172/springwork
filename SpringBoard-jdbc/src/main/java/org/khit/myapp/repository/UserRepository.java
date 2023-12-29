package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.khit.myapp.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원가입 처리
	public void save(UserDTO user) {
		conn = JDBCUtil.getConnection();
		String sql = "insert into users(userid, userpasswd, username, userage) "
				+ "values(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setInt(4, user.getUserAge());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	//로그인 처리
	public UserDTO login(UserDTO user) {
		conn = JDBCUtil.getConnection();
		String sql = "select * from users where userid=? and userpasswd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPasswd());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
