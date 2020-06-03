package com.web.hissafy.dto;

public class DuringStudentDto {
	private String student_id;
	private String area;
	private int group_num; 
	private int class_num;
	private String name;
	private String state;
	private String face_id;
	private String attendance_date;
	private String attendance_time;
	private String leaving_time;
	private String attendance_state;
	
	public DuringStudentDto() {
		super();
	}
	
	public DuringStudentDto(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id, String attendance_date, String attendance_time, String leaving_time,
			String attendance_state) {
		super();
		this.student_id = student_id;
		this.area = area;
		this.group_num = group_num;
		this.class_num = class_num;
		this.name = name;
		this.state = state;
		this.face_id = face_id;
		this.attendance_date = attendance_date;
		this.attendance_time = attendance_time;
		this.leaving_time = leaving_time;
		this.attendance_state = attendance_state;
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

	public String getAttendance_date() {
		return attendance_date;
	}

	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}

	public String getAttendance_time() {
		return attendance_time;
	}

	public void setAttendance_time(String attendance_time) {
		this.attendance_time = attendance_time;
	}

	public String getLeaving_time() {
		return leaving_time;
	}

	public void setLeaving_time(String leaving_time) {
		this.leaving_time = leaving_time;
	}

	public String getAttendance_state() {
		return attendance_state;
	}

	public void setAttendance_state(String attendance_state) {
		this.attendance_state = attendance_state;
	}

	@Override
	public String toString() {
		return "DuringStudentDto [student_id=" + student_id + ", area=" + area + ", group_num=" + group_num
				+ ", class_num=" + class_num + ", name=" + name + ", state=" + state + ", face_id=" + face_id
				+ ", attendance_date=" + attendance_date + ", attendance_time=" + attendance_time + ", leaving_time="
				+ leaving_time + ", attendance_state=" + attendance_state + "]";
	}
}
