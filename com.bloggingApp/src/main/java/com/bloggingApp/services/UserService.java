package com.bloggingApp.services;

import java.util.List;

import com.bloggingApp.entitiesDtos.UserDto;


public interface UserService {

	UserDto createUser (UserDto usersDto);
	
	UserDto updateUser (UserDto usersDto,Long userId);
	
	UserDto getUserById (Long userId);
	
	List<UserDto> getAllUsers (Integer pNum,Integer pSize);

	void deleteUser (Long userId);

}
