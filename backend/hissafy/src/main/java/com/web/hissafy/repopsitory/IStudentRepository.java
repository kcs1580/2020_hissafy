package com.web.hissafy.repopsitory;

import java.util.List;

import com.web.hisssafy.dto.StudentDto;

public interface IStudentRepository {
	public int studentInsert(StudentDto student);

	public int studentUpdate(StudentDto student);

	public StudentDto studentInfo(int student_id);

	public List<StudentDto> studentList();
	
}
