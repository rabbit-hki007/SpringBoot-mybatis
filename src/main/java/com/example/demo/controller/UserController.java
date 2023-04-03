package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.common.EnumRole;
import com.example.demo.dto.common.ResponseDto;
import com.example.demo.service.UserService;


@Controller
//@RequiredArgsConstructor
public class UserController {
	
	//logback이 스프링 boot에 기본 탑재
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
    //private final Logger logger = LoggerFactory.getLogger("LoggerController 의 로그");
	
	@Autowired
	UserService userService;
	
	//@RequiredArgsConstructor 이것을 사용하면 아래 것으로 사용
	//private final UserService userService;
	
    @GetMapping("/")
    public String index() {
        return "index";
    }
	
    @GetMapping("/user/listModelAndView")
    public ModelAndView userList() {
    	//System.out.println("여기는 /user/list");
    	logger.info("여기는 /user/list");
    	List<HashMap<String, Object>> userList = userService.getUsers();
    	
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("user/userList");
    	mv.addObject("userList", userList);
    	logger.info("회원리스트(ModelAndView) : " + userList.toString());
        
        return mv;
    }
    
    @GetMapping("/user/listModel")
    public String userList1(Model model) {
    	//System.out.println("여기는 /user/list");
    	logger.info("여기는 /user/list");
    	List<HashMap<String, Object>> userList = userService.getUsers();
    	logger.info("회원리스트(Model) : " + userList.toString());
    	
    	model.addAttribute("userList", userList);
    
        return "user/userList";
    }
    
    @GetMapping("/user/userAddForm")
    public String userAdd() {
    	logger.info("여기는 /user/userAddForm");
        return "user/userAddForm";
    }
    
    @PostMapping("/user/controllerUserAddProc")
    public  String contollerUserAddProc(@RequestParam(value="username") String username,
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
    	
    	return "redirect:/user/listModel";
   
    }
    
    
    @GetMapping("/user/detailForm")
    public String detailForm() {
    	logger.info("여기는 /user/detailForm");
        return "user/userDetailForm";
    }
    
    @GetMapping("/user/updateForm")
    public String updateForm() {
    	logger.info("여기는 /user/updateForm");
        return "user/userUpdateForm";
    }


}
