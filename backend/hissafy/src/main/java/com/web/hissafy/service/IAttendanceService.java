package com.web.hissafy.service;

import java.util.List;

import com.web.hissafy.dto.AttendanceDto;

public interface IAttendanceService {
	public int attendanceInsert(AttendanceDto attendance);
	
	public int attendanceUpdateAttendance(AttendanceDto attendance);
	
	public int attendanceUpdateLeaving(AttendanceDto attendance);

	public AttendanceDto attendanceInfo(int student_id);

	public List<AttendanceDto> attendanceList();
}
