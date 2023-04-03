package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
	
	@Autowired
    private UserMapper userMapper;
	
    @Autowired
    private UserDao userDao;

//    @autowired 대신 아래처럼 생성자로 생성해서 쓰기도 함    
//    public UserService(UserMapper userMapper, UserDao userDao){
//        this.userMapper = userMapper;
//        this.userDao = userDao;
//    }

    public List<HashMap<String, Object>> getUsers() {
        return userMapper.selectUsers();
    }

    public List<HashMap<String, Object>> getUsersWithDao() {
        return userDao.getUsers();
    }

	public int saveUser(UserDto userDto) {
		int result = userDao.saveUser(userDto);
		return result;
	}
    
}
