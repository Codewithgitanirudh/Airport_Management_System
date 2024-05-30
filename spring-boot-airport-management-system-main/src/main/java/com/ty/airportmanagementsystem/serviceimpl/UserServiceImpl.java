package com.ty.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.airportmanagementsystem.dao.UserDao;
import com.ty.airportmanagementsystem.dto.User;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.UserService;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private ApplicationResponse<User> applicationResponse;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<User> userRegisterService(User user) {
		User user2 = userDao.userRegisterdao(user);
		if(user2!=null) {
			applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			applicationResponse.setMessage("user--registered-successfully");
			applicationResponse.setDescription("you can follow below data what is added inside table");
			applicationResponse.setData(user2);
			return applicationResponse;
		}else {
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("user--registeration--unsuccesfull");
			applicationResponse.setDescription("check sql query or database");
			applicationResponse.setData(null);
			return applicationResponse;
		}
		
	}

	@Override
	public ApplicationResponse<User> fetchByUserByEmailForLoginService(String email, String password) {
		User user = userDao.fetchUserByEmailForLoginDaos(email);
		if(user!=null) {
			
			if(user.getUserPassword().equals(password)) {
				httpSession.setAttribute("userSession", email);
				applicationResponse.setStatusCode(HttpStatus.FOUND.value());
				applicationResponse.setMessage("user-logged-in-Successfully");
				applicationResponse.setDescription("user Session created");
				applicationResponse.setData(user);
				return applicationResponse;
			}else {
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("password is incorrect");
				applicationResponse.setDescription("you can follow below data what is added inside table");
				applicationResponse.setData(null);
				return applicationResponse;
			}
			
		}else {
			applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			applicationResponse.setMessage("given - email- is not found");
			applicationResponse.setDescription("u can follow below data what is addedd inside table");
			applicationResponse.setData(null);
			return applicationResponse;
		}
	}

}
