package com.khit.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString*/
@Data
public class UserDTO {
	//ÇÊµå
	private Long id;
	private String userId;
	private String userPasswd;
	private String userName;
	private String userAge;
}
