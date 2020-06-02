package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.hissafy.repopsitory.IAttendanceRepository;
import com.web.hisssafy.dto.AttendanceDto;

public class AttendanceServiceImpl implements IAttendanceService {
	@Autowired
	IAttendanceRepository repo;

	@Override
	public int attendanceInsert(int student_id, String attendance_date, String attendance_state) {
		return repo.attendanceInsert(new AttendanceDto(student_id, attendance_date, attendance_state));
	}

	@Override
	public int attendanceUpdateAttendance(int student_id, String attendance_date, String attendance_time,
			String attendance_state) {
		return repo.attendanceUpdateAttendance(new AttendanceDto(student_id, attendance_date, attendance_time, null, attendance_state));
	}

	@Override
	public int attendanceUpdateLeaving(int student_id, String attendance_date, String leaving_time,
			String attendance_state) {
		return repo.attendanceUpdateLeaving(new AttendanceDto(student_id, attendance_date, null, leaving_time, attendance_state));
	}

	@Override
	public AttendanceDto attendanceInfo(int student_id) {
		return repo.attendanceInfo(student_id);
	}

	@Override
	public List<AttendanceDto> attendanceList() {
		return repo.attendanceList();
	}

}
