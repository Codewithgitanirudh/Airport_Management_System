package com.ty.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.airportmanagementsystem.dto.User;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/userRegister")
	public ApplicationResponse<User> userRegisterController(@RequestBody User user){
		return userService.userRegisterService(user);
	}
	
	@GetMapping(value="/loginUser/{email}/{password}")
	public ApplicationResponse<User> fetchUserByEmailForLogin(@PathVariable(name="email") String email, @PathVariable(name="password") String password){
		return userService.fetchByUserByEmailForLoginService(email, password);
	}
	
}
