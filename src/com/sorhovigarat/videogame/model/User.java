package com.sorhovigarat.videogame.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private Role role;
	
	public User() {
		super();
	}
	public User(int id, String userName, String password, Role role)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public User(String userName, String password, Role role)
	{
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
