package com.bloggingApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloggingApp.configurations.BloggingAppConstants;
import com.bloggingApp.entitiesDtos.UserDto;
import com.bloggingApp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

//..............................................	

//1.create user...............................	

//http://localhost:8083/api/users/
	@PostMapping ("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {	
	
	UserDto createdUser=this.userService.createUser(userDto);
	return new ResponseEntity<UserDto>(createdUser ,HttpStatus.CREATED);
	}
	
//2.update user...............................	
	
//http://localhost:8083/api/users/2	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Long userId) {

	UserDto updatedUser = this.userService.updateUser(userDto, userId);
	return new ResponseEntity<UserDto>(updatedUser,HttpStatus.CREATED);
	
	}
	
//3.get/find user by id...............................	
	
//http://localhost:8083/api/users/2	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
	UserDto userByIdDto = this.userService.getUserById(userId);
	return new ResponseEntity<UserDto>(userByIdDto,HttpStatus.OK);
			
	}
	
//4.get/find all users...............................	

//http://localhost:8083/api/users/?pNum=1&pSize=3	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(
			@RequestParam (value ="pNum",defaultValue =BloggingAppConstants.PAGE_NUMBER,required = false)Integer pNum,
			@RequestParam (value ="pSize",defaultValue =BloggingAppConstants.PAGE_SIZE,required = false)Integer pSize) 
	{
	
    List<UserDto> allUsers = this.userService.getAllUsers(pNum,pSize);
    return new ResponseEntity<List<UserDto>> (allUsers,HttpStatus.OK);
	
	}
	
//5.delete users by id...............................	
	
//http://localhost:8083/api/users/3	
		@DeleteMapping("/{userId}")
		public ResponseEntity<?> deleteUser( @PathVariable Long userId) {
			
			this.userService.deleteUser(userId);
			return new ResponseEntity <> ("Deleted user successfully by shinde",HttpStatus.OK);
	
		}	
	
	

}
