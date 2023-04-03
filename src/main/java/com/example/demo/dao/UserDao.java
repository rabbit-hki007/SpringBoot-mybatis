package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserMapper;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDao {
	
	@Autowired
    private SqlSession sqlSession;
    
//    public UserDao(SqlSession sqlSession){
//        this.sqlSession = sqlSession;
//    }
	
    public List<HashMap<String, Object>> getUsers() {
    	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUsers();
    }

	public int saveUser(UserDto userDto) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int result = mapper.saveUser(userDto);
		return result;
	}
    
//   아래쪽것으로 해도 동작됨 그래도 보기 좋은 것은 위의 코드겠죠
//    public List<HashMap<String, Object>> getUsers() {
//        return sqlSession.selectList("com.example.demo.service.UserMapper.selectUsers");
//    }
    
}
