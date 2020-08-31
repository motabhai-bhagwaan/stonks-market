package com.stonks.userservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stonks.userservice.dto.UserRequestDto;
import com.stonks.userservice.dto.UserResponseDto;
import com.stonks.userservice.model.User;
import com.stonks.userservice.services.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private ModelMapper modelMapper;
	private UserService userService;

	@RequestMapping("/signup")
	public UserResponseDto userSignUp(UserRequestDto userDto) throws Exception {
		if(!userService.checkUserExists(userDto)){
			throw new Exception("User exists!");
		}
		return userService.addUser(userDto);
	}
	
	@RequestMapping("/login")
	public UserResponseDto userLogin(UserRequestDto userDto) throws Exception{
		if(userService.checkUserExists(userDto)){
			throw new Exception("User does not exist!");
		}
		else {
			UserResponseDto user = userService.authenticateUser(userDto);
			if(user == null){
				throw new Exception("Invalid Credentials!");
			}
			return user;
		}
	}
	
}
