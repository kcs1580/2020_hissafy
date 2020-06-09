package com.web.hissafy.repopsitory;

import java.util.List;

import com.web.hissafy.dto.DuringStudentDto;
import com.web.hissafy.dto.StudentDto;

public interface IStudentRepository {
	public int studentInsert(StudentDto student);

//	public int studentListInsert(List<StudentDto> list);
	
	public int studentUpdate(StudentDto student);

	public StudentDto studentInfo(String student_id);

	public List<StudentDto> studentList();
	
	public List<DuringStudentDto> studentDuringList();
	
}
