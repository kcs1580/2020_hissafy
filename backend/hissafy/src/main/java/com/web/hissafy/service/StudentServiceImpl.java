package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.hissafy.repopsitory.IStudentRepository;
import com.web.hisssafy.dto.StudentDto;

public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	IStudentRepository repo;

	@Override
	public int studentInsert(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id) {
		return repo.studentInsert(new StudentDto(student_id, area, group_num, class_num, name, state, face_id));
	}

	@Override
	public int studentUpdate(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id) {
		return repo.studentUpdate(new StudentDto(student_id, area, group_num, class_num, name, state, face_id));
	}

	@Override
	public StudentDto studentInfo(int id) {
		return repo.studentInfo(id);
	}

	@Override
	public List<StudentDto> studentList() {
		return repo.studentList();
	}

}
