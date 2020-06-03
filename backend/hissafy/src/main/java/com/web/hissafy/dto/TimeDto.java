package com.web.hissafy.dto;

public class TimeDto {
	int time_id;
	String attendance_start_h;
	String attendance_start_m;
	String attendance_end_h;
	String attendance_end_m;
	String leaving_start_h;
	String leaving_start_m;
	String leaving_end_h;
	String leaving_end_m;

	public TimeDto(String attendance_start_h, String attendance_start_m, String attendance_end_h,
			String attendance_end_m, String leaving_start_h, String leaving_start_m, String leaving_end_h,
			String leaving_end_m) {
		super();
		this.attendance_start_h = attendance_start_h;
		this.attendance_start_m = attendance_start_m;
		this.attendance_end_h = attendance_end_h;
		this.attendance_end_m = attendance_end_m;
		this.leaving_start_h = leaving_start_h;
		this.leaving_start_m = leaving_start_m;
		this.leaving_end_h = leaving_end_h;
		this.leaving_end_m = leaving_end_m;
	}

	public int getTime_id() {
		return time_id;
	}

	public TimeDto(int time_id, String attendance_start_h, String attendance_start_m, String attendance_end_h,
			String attendance_end_m, String leaving_start_h, String leaving_start_m, String leaving_end_h,
			String leaving_end_m) {
		super();
		this.time_id = time_id;
		this.attendance_start_h = attendance_start_h;
		this.attendance_start_m = attendance_start_m;
		this.attendance_end_h = attendance_end_h;
		this.attendance_end_m = attendance_end_m;
		this.leaving_start_h = leaving_start_h;
		this.leaving_start_m = leaving_start_m;
		this.leaving_end_h = leaving_end_h;
		this.leaving_end_m = leaving_end_m;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public TimeDto() {
		super();
	}

	public String getAttendance_start_h() {
		return attendance_start_h;
	}

	public void setAttendance_start_h(String attendance_start_h) {
		this.attendance_start_h = attendance_start_h;
	}

	public String getAttendance_start_m() {
		return attendance_start_m;
	}

	public void setAttendance_start_m(String attendance_start_m) {
		this.attendance_start_m = attendance_start_m;
	}

	public String getAttendance_end_h() {
		return attendance_end_h;
	}

	public void setAttendance_end_h(String attendance_end_h) {
		this.attendance_end_h = attendance_end_h;
	}

	public String getAttendance_end_m() {
		return attendance_end_m;
	}

	public void setAttendance_end_m(String attendance_end_m) {
		this.attendance_end_m = attendance_end_m;
	}

	public String getLeaving_start_h() {
		return leaving_start_h;
	}

	public void setLeaving_start_h(String leaving_start_h) {
		this.leaving_start_h = leaving_start_h;
	}

	public String getLeaving_start_m() {
		return leaving_start_m;
	}

	public void setLeaving_start_m(String leaving_start_m) {
		this.leaving_start_m = leaving_start_m;
	}

	public String getLeaving_end_h() {
		return leaving_end_h;
	}

	public void setLeaving_end_h(String leaving_end_h) {
		this.leaving_end_h = leaving_end_h;
	}

	public String getLeaving_end_m() {
		return leaving_end_m;
	}

	public void setLeaving_end_m(String leaving_end_m) {
		this.leaving_end_m = leaving_end_m;
	}

	@Override
	public String toString() {
		return "TimeDto [attendance_start_h=" + attendance_start_h + ", attendance_start_m=" + attendance_start_m
				+ ", attendance_end_h=" + attendance_end_h + ", attendance_end_m=" + attendance_end_m
				+ ", leaving_start_h=" + leaving_start_h + ", leaving_start_m=" + leaving_start_m + ", leaving_end_h="
				+ leaving_end_h + ", leaving_end_m=" + leaving_end_m + "]";
	}

}
