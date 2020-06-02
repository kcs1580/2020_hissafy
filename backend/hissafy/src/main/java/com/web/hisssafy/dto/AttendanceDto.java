package com.web.hisssafy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class AttendanceDto {
	private int student_id;
	private String attendance_date;
	private String attendance_time;
	private String leaving_time;
	private String attendance_state;
	
	public AttendanceDto() {
		super();
	}
	
	public AttendanceDto(int student_id, String attendance_date) {
		super();
		this.student_id = student_id;
		this.attendance_date = attendance_date;
	}
	
	public AttendanceDto(int student_id, String attendance_date, String attendance_time, String leaving_time, String attendance_state) {
		super();
		this.student_id = student_id;
		this.attendance_date = attendance_date;
		this.attendance_time = attendance_time;
		this.leaving_time = leaving_time;
		this.attendance_state = attendance_state;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
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
		return "AttendanceDto [student_id=" + student_id + ", attendance_date=" + attendance_date + ", attendance_time="
				+ attendance_time + ", leaving_time=" + leaving_time + ", attendance_state=" + attendance_state + "]";
	}
}
