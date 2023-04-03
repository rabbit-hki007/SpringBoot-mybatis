package com.example.demo.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

import java.util.HashMap;
import java.util.List;


// 이것을 바로 붙여서 사용하기 위해 Mapper 이면서 Repository로 등록
@Mapper
@Repository
public interface UserMapper {
	
    List<HashMap<String, Object>> selectUsers();

    // 사용자(회원) 저장
	int saveUser(UserDto userDto);
    
}
