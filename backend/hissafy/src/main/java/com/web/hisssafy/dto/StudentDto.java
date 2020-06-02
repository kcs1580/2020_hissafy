package com.web.hisssafy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class StudentDto {
	private String student_id;
	private String area;
	private int group_num; 
	private int class_num;
	private String name;
	private String state;
	private String face_id;
	
	public StudentDto() {
		super();
	}

	public StudentDto(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id) {
		super();
		this.student_id = student_id;
		this.area = area;
		this.group_num = group_num;
		this.class_num = class_num;
		this.name = name;
		this.state = state;
		this.face_id = face_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFace_id() {
		return face_id;
	}

	public void setFace_id(String face_id) {
		this.face_id = face_id;
	}

	@Override
	public String toString() {
		return "StudentDto [student_id=" + student_id + ", area=" + area + ", group_num=" + group_num + ", class_num="
				+ class_num + ", name=" + name + ", state=" + state + ", face_id=" + face_id + "]";
	}
}
