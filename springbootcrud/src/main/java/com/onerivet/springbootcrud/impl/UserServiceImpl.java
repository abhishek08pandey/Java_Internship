package com.onerivet.springbootcrud.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.onerivet.springbootcrud.service.UserService;
import com.onerivet.springbootcrud.user.User;

@Service
public class UserServiceImpl implements UserService {

// Use Map collection
	private static Map<Integer, User> mapUser = new HashMap<Integer, User>();

	@Override
	public String addUser(Integer idUser, User user) {
		
	 mapUser.put(idUser, user);
	 return "Add Successfull"
			 ;
	}

	@Override
	public List<User> getRecords() {
		
		return mapUser.values().stream().toList();
	}

	@Override
	public User getSingleUser(Integer idUser) {

		return mapUser.get(idUser);
	}

	@Override
	public String updateUser(Integer idUser, User user) {

		user.setId(idUser);
		
		User replace = mapUser.replace(idUser, user);
		if (replace != null) {

			return "Update Successful";
		}
		return "User not found";
	}

	@Override
	public String deleteUser(Integer idUser) {

		User remove = mapUser.remove(idUser);
		if (remove != null) {
			return "Delete...";
		}
		return "User does not found";
	}

}
