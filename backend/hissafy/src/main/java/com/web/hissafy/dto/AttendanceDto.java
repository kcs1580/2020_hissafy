package com.web.hissafy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class AttendanceDto {
	private String student_id;
	private String attendance_date;
	private String attendance_time;
	private String leaving_time;
	private String attendance_state;
	private String student_name;
	
	public AttendanceDto(String student_id, String attendance_date, String attendance_time, String leaving_time,
			String attendance_state, String student_name) {
		super();
		this.student_id = student_id;
		this.attendance_date = attendance_date;
		this.attendance_time = attendance_time;
		this.leaving_time = leaving_time;
		this.attendance_state = attendance_state;
		this.student_name = student_name;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public AttendanceDto() {
		super();
	}
	
	public AttendanceDto(String student_id, String attendance_date) {
		super();
		this.student_id = student_id;
		this.attendance_date = attendance_date;
	}
	
	public AttendanceDto(String student_id, String attendance_date, String attendance_time, String leaving_time, String attendance_state) {
		super();
		this.student_id = student_id;
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
