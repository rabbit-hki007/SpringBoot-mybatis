package com.example.demo.controller.restApiController;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.common.EnumRole;
import com.example.demo.dto.common.ResponseDto;
import com.example.demo.service.UserService;

@RestController
//@RequiredArgsConstructor
public class UserRESTApiController {
	
	//@RequiredArgsConstructor 로 쓰는경우는 아래와 같이 쓸수 있다
	//private final UserService userService;
    
	@Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<HashMap<String, Object>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/usersDao")
    public List<HashMap<String, Object>> getUsersDao() {
        return userService.getUsersWithDao();
    }
    
    @PostMapping("/user/restcontrollerUserAddProc")
    public ResponseDto<Integer> restcontrollerUserAddProc(@RequestParam(value="username") String username,
    		                  @RequestParam(value="password") String password,
    		                  HttpServletRequest request,
    		                  @ModelAttribute UserDto userDto,
    		                  UserDto userDto1  ) {
    	
    	System.out.println("@RequestParam 아이디 : " + username);
    	System.out.println("@RequestParam 비밀번호 : " + password);
    	
    	System.out.println("HttpServletRequest 아이디 : " +  request.getParameter("username"));
    	System.out.println("HttpServletRequest 비밀번호 : " + request.getParameter("password"));
       
    	System.out.println("@ModelAttribute 아이디 : " + userDto1.getUsername());
    	System.out.println("@ModelAttribute 비밀번호 : " + userDto1.getPassword());
    	
    	System.out.println("userDto1 아이디 : " + userDto1.getUsername());
    	System.out.println("userDto1 비밀번호 : " + userDto1.getPassword());
    	
    	userDto.setRolecode(EnumRole.USER.getRolecode());
    	System.out.println("userDto.setRole" + userDto.getRolecode());
    	int result = userService.saveUser(userDto);
    	
    	return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
   
    }
    
    
    @PostMapping("/user/ajaxFetchAsyncAxioRestcontrollerUserAddProc")
    public @ResponseBody ResponseDto<Integer> ajaxrestcontrollerUserAddProc(@RequestBody UserDto userDto ) {
    	
    	   	
    	System.out.println("userDto 아이디 : " + userDto.getUsername());
    	System.out.println("userDto 비밀번호 : " + userDto.getPassword());
    	
    	userDto.setRolecode(EnumRole.USER.getRolecode());
    	System.out.println("userDto.setRole : " + userDto.getRolecode());
    	int result = userService.saveUser(userDto);
    	
    	//Content-type : application/json;charset=utf-8
    	//HttpServletResponse response;
        //response.setContentType("application/json");
        //response.setCharacterEncoding("utf-8");
    	
    	return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
   
    }
    
    
    
    
//    @PostMapping("/user/addProc")
//    public  void userAddProc(@RequestParam String username,
//    						@RequestParam String password ) {
//       
//    	System.out.println("아이디 : " + username);
//    	System.out.println("비밀번호 : " + password);
//    	
//    	// userService.userAddProc;
//    }
        
    @GetMapping("/user/addProc")
    public  void userAddProcGet(@RequestParam(value="username") String username,
    							@RequestParam(value="password") String password ) {
       
    	System.out.println("아이디 : " + username);
    	System.out.println("비밀번호 : " + password);
    	
    	// userService.userAddProc;
    }
    
    
}
