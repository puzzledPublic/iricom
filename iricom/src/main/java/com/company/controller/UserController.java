package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.UserVo;
import com.company.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	//회원 가입 폼
	@RequestMapping(value="/user/join",method=RequestMethod.GET)
	public String joinForm(){
		return "/user/join";
	}
	//회원 가입 
	@RequestMapping(value="/user/join", method=RequestMethod.POST)
	public String join(@RequestParam(value="join_user_agree", required=true) String agree,
					   @RequestParam(value="join_user_agree2", required=true) String agree2,
					   @RequestParam(value="userid",required=true) String userId,
					   @RequestParam(value="userpw",required=true) String password,
					   @RequestParam(value="userpw_confirm",required=true) String passwordConfirm,
					   @RequestParam(value="username",required=true) String userName,
					   @RequestParam(value="postcode",required=true) String postcode,
					   @RequestParam(value="address", required=true) String address,
					   @RequestParam(value="email", required=true) String email){

		if(!agree.trim().equals("1")||!agree2.trim().equals("1")){
			return "redirect:/error";
		}
		if(userId.isEmpty()||password.isEmpty()||passwordConfirm.isEmpty()||userName.isEmpty()||postcode.isEmpty()||address.isEmpty()||email.isEmpty()){
			return "redirect:/error";
		}
		
		if(userId.length()<4||password.length()<4||email.length()<7||userName.length()<2||postcode.length()<5){
			return "redirect:/error";
		}
		
		if(!password.equals(passwordConfirm)){
			return "redirect:/error";
		}
		int postcodeInt;
		
		try{
			postcodeInt = Integer.parseInt(postcode); 
		}catch(Exception e){
			return "redirect:/error";
		}
		
		if(userServiceImpl.selectOneBool(userId)){
			return "redirect:/error";
		}
		
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setPassword(password);
		userVo.setUserName(userName);
		userVo.setPostcode(postcodeInt);
		userVo.setAddress(address);
		userVo.setEmail(email);
		
		userServiceImpl.insertUser(userVo);
		
		return "redirect:/user/login";
	}
}
