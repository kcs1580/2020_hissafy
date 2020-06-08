package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.dto.AttendanceDto;
import com.web.hissafy.dto.StudentDto;
import com.web.hissafy.repopsitory.IAttendanceRepository;
import com.web.hissafy.repopsitory.IStudentRepository;

@Service
public class AttendanceServiceImpl implements IAttendanceService {
	@Autowired
	IAttendanceRepository repo;

	@Autowired 
	IStudentRepository sRepo;
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
	public AttendanceDto attendanceInfo(String student_id) {
		return repo.attendanceInfo(student_id);
	}

	@Override
	public List<AttendanceDto> attendanceList() {
		return repo.attendanceList();
	}
	@Override
	public List<AttendanceDto> attendanceDateList(String date) {
		List<AttendanceDto> list = repo.attendanceDateList(date);
		for (int i = 0; i < list.size(); i++) {
			AttendanceDto dto = list.get(i);
			StudentDto student = sRepo.studentInfo(dto.getStudent_id());
			dto.setStudent_name(student.getName());
		}
		return list;
	}

}
