package com.onerivet.springbootcrud.service;

import java.util.List;

import com.onerivet.springbootcrud.user.User;

public interface UserService {

	public String addUser(Integer idUser, User user);

	public List<User> getRecords();

	public User getSingleUser(Integer idUser);

	public String updateUser(Integer idUser, User user);
	
	public String deleteUser(Integer idUser);
}
