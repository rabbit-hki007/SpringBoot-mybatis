package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private String username;
	private String password;
	private String rolecode;
	private String regdate;
	private String updatedate;
	
}
