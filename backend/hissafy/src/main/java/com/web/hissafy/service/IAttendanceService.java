package com.web.hissafy.service;

import java.util.List;

import com.web.hisssafy.dto.AttendanceDto;

public interface IAttendanceService {
	public int attendanceInsert(int student_id, String attendance_date, String attendance_state);
	
	public int attendanceUpdateAttendance(int student_id, String attendance_date, String attendance_time, String attendance_state);
	
	public int attendanceUpdateLeaving(int student_id, String attendance_date, String leaving_time, String attendance_state);

	public AttendanceDto attendanceInfo(int student_id);

	public List<AttendanceDto> attendanceList();
}
