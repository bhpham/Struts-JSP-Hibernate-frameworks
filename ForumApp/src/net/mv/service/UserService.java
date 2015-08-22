package net.mv.service;

import java.sql.SQLException;

import net.mv.dao.UserDao;
import net.mv.domain.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public boolean AuthenticateUser(User user) {
		
		boolean authenticated = false;
		User userFromDB = userDao.retrieveUser(user.getUsername());
		/*
		 * retrieve all the Users and check password and Username
		 */
		if(userFromDB != null && userFromDB.getPassword().equals(user.getPassword())){
			authenticated = true;
			user.setu_id(userFromDB.getu_id());
		}
		
		return authenticated;
	}
	
	public boolean registerdUser(User user) {
		boolean exists = false;
		
		try {
			userDao.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			exists = true;
		}
		
		return exists;
	}
	
}
