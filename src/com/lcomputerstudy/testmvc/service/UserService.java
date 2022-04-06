package com.lcomputerstudy.testmvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.lcomputerstudy.testmvc.dao.UserDAO;
import com.lcomputerstudy.testmvc.vo.User;

public class UserService {
	
	private static UserService service = null;
	private static UserDAO dao = null;
    
	private UserService() {
		
	}

	public static UserService getInstance() {
		if(service == null) {
			service = new UserService();
			dao = UserDAO.getInstance();
		}
		return service;
	}

	public ArrayList<User> getUsers() {
		return dao.getUsers();
	}
	
	public void insertUser(User user) {
		dao.insertUser(user);
	}
	
	public User getDetail(User user) {
		return dao.getDetail(user);
	}

	public void editUser(User user){
		dao.getEdit(user);
		
	}

	public User getDelete(User user) {
		dao.getDelete(user);
		return null;
	}
}