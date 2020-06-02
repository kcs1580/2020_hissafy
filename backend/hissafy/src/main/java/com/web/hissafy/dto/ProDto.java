package com.web.hissafy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class ProDto {
	private String user_id; 
	private String user_pw; 
	private String user_name; 
	private String location;
	
	public ProDto(String user_id, String user_pw, String user_name, String location) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.location = location;
	}
	public ProDto() {
		super();
	}
	public ProDto(String user_id, String user_pw, String user_name) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
	}	
	public ProDto(String user_id, String user_pw) {
		this.user_id = user_id; 
		this.user_pw = user_pw;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "ProDto [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", location="
				+ location + "]";
	}
	
}
