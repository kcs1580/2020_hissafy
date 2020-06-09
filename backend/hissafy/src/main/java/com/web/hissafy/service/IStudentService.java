package com.web.hissafy.service;

import java.util.List;

import com.web.hissafy.dto.DuringStudentDto;
import com.web.hissafy.dto.StudentDto;

public interface IStudentService {
	// 교육생 등록
	public int studentInsert(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id);

	// 교육생 리스트 등록
	public int studentListInsert(List<StudentDto> list);
		
	// 교육생 정보 수정
	public int studentUpdate(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id);

	// 교육생 정보
	public StudentDto studentInfo(String student_id);

	// 교육생 전체 정보
	public List<StudentDto> studentList();
	
	// 입과중인 교육생 전체 정보
	public List<DuringStudentDto> studentDuringList();
}
