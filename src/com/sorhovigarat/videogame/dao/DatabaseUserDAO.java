package com.sorhovigarat.videogame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sorhovigarat.videogame.model.User;
import com.sorhovigarat.videogame.util.DBConnection;

public class DatabaseUserDAO {
public String checkUser(String username, String password) {
		
		String sqlQuery = "SELECT * "
				+ "FROM users "
				+ "WHERE username = ? and passphrase = ?";
		
		try (Connection connection = DBConnection.getConnection()) {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if(rs.getInt(4) == 1)
				{
					return "Hello " + username + ". You are signed in with an admin account.";
				}
				else if(rs.getInt(4) == 2)
				{
					return "Hello " + username + ". You are signed in with a regular user account.";
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "Login failed. Please try again";
	}
}
