package com.ty.airportmanagementsystem.dao;

import com.ty.airportmanagementsystem.dto.User;

public interface UserDao {
	
	public User userRegisterdao(User user);
	public User fetchUserByEmailForLoginDaos(String email);
}
