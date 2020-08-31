package com.stonks.userservice.services;

import com.stonks.userservice.dao.UserDao;
import com.stonks.userservice.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stonks.userservice.dto.UserRequestDto;
import com.stonks.userservice.dto.UserResponseDto;

@Service
public class UserService {

	@Autowired
	private UserDao repo;
	@Autowired
	private ModelMapper modelMapper;

	public boolean checkUserExists(UserRequestDto user){
		return repo.findByUsername(modelMapper.map(user, User.class).getUsername()) == null;
	}

	public UserResponseDto addUser(UserRequestDto user) {
		repo.save(modelMapper.map(user, User.class));
		return modelMapper.map(user, UserResponseDto.class);
	}

	private UserRequestDto findByUsername(String username) {
		return modelMapper.map(repo.findByUsername(username), UserRequestDto.class);
	}

	public UserResponseDto authenticateUser(UserRequestDto userDto) throws Exception{
		User user = modelMapper.map(userDto, User.class);
		User realUser = repo.findByUsername(user.getUsername());
		if(realUser.getPassword().equals(user.getPassword())){
			return modelMapper.map(realUser, UserResponseDto.class);
		}
		return null;
	}
}
