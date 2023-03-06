package com.bloggingApp.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.entities.User;
import com.bloggingApp.entitiesDtos.UserDto;
import com.bloggingApp.exceptions.ResourceNotFoundExceptionnn;
import com.bloggingApp.repositories.UserRepo;
import com.bloggingApp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
//................................................................
	
//1.create user...............................	
	
	@Override
	public UserDto createUser(UserDto userDto) {

		User user=this.modelMapper.map(userDto,User.class);
		User savedUser=this.userRepo.save(user);
		
		UserDto userToUserDto=this.modelMapper.map(savedUser,UserDto.class);
		return userToUserDto;
	}
	
	
//2.update user...............................	

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {

		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptionnn("user","userId id",userId));
		
		user.setUserName(userDto.getUserName());
		user.setUserMail(userDto.getUserMail());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserAbout(userDto.getUserAbout());
		
	   User updatedUser=this.userRepo.save(user);
		
		UserDto userToUserDto_updateDto=this.modelMapper.map(updatedUser, UserDto.class);
	   
		return userToUserDto_updateDto;
	}


//3.get/find user by id...............................	
	
//	@Override
	public UserDto getUserById(Long userId) {

		User requiredUser= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptionnn("user","userId id",userId) );
	UserDto userToUserDto_user=	this.modelMapper.map(requiredUser,UserDto.class);
		
		return userToUserDto_user;
	}


//4.get/find all users...............................	

	@Override
	public List<UserDto> getAllUsers() {
		
    List<User> allUsers= this.userRepo.findAll();
    List<UserDto> allUsers_dto = allUsers.stream().map((user)->this.modelMapper.map(user,UserDto.class))
    		                                      .collect(Collectors.toList());

     return allUsers_dto;
	}

//5.delete users by id...............................	
	
	@Override
	public void deleteUser(Long userId) {

	User userToDelete=	this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptionnn("user","user id",userId));
	this.userRepo.delete(userToDelete);
	
	}


}
