package com.web.hissafy.repopsitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.hisssafy.dto.AttendanceDto;

public class AttendanceRepositoryImpl implements IAttendanceRepository{
	@Autowired
	SqlSession session;

	@Override
	public int attendanceInsert(AttendanceDto attendance) {
		return session.insert("hissafy.attendance.insert",attendance);
	}

	@Override
	public int attendanceUpdateAttendance(AttendanceDto attendance) {
		return session.update("hissafy.attendace.updateAttendance",attendance);
	}

	@Override
	public int attendanceUpdateLeaving(AttendanceDto attendance) {
		return session.update("hissafy.attendace.updateLeaving",attendance);
	}

	@Override
	public AttendanceDto attendanceInfo(int student_id) {
		return session.selectOne("hissafy.attendance.selectOne",student_id);
	}

	@Override
	public List<AttendanceDto> attendanceList() {
		return session.selectList("hissafy.attendance.selectList");
	}
}
