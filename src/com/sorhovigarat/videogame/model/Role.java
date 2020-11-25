package com.sorhovigarat.videogame.model;

public class Role {
	private int roleID;
	private String roleTitle;
	
	public Role() {
		super();
	}
	public Role(int roleID, String roleTitle)
	{
		this.roleID = roleID;
		this.roleTitle = roleTitle;
	}
	public Role(String roleTitle)
	{
		this.roleTitle = roleTitle;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
}
