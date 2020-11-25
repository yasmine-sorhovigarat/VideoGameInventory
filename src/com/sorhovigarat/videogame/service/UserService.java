package com.sorhovigarat.videogame.service;

import java.util.ArrayList;

import com.sorhovigarat.videogame.dao.DatabaseUserDAO;
import com.sorhovigarat.videogame.dao.DatabaseVideoGameDAO;
import com.sorhovigarat.videogame.model.VideoGame;

public class UserService {
	private DatabaseUserDAO userDAO;
	
	public UserService() {
		this.userDAO = new DatabaseUserDAO();
	}
	
	public UserService(DatabaseUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public String checkUser (String username, String password) {
		return userDAO.checkUser(username, password);
	}
}
