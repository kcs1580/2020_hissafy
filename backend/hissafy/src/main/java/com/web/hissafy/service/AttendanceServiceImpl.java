package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.repopsitory.IAttendanceRepository;
import com.web.hisssafy.dto.AttendanceDto;

@Service
public class AttendanceServiceImpl implements IAttendanceService {
	@Autowired
	IAttendanceRepository repo;

	@Override
	public int attendanceInsert(AttendanceDto attendance) {
		return repo.attendanceInsert(attendance);
	}

	@Override
	public int attendanceUpdateAttendance(AttendanceDto attendance) {
		return repo.attendanceUpdateAttendance(attendance);
	}

	@Override
	public int attendanceUpdateLeaving(AttendanceDto attendance) {
		return repo.attendanceUpdateLeaving(attendance);
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
