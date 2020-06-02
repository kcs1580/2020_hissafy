package com.web.hissafy.repopsitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.hisssafy.dto.StudentDto;

public class StudentRepositoryImpl implements IStudentRepository {
	@Autowired
	SqlSession session;

	@Override
	public int studentInsert(StudentDto student) {
		return session.insert("hissafy.student.insert",student);
	}

	@Override
	public int studentUpdate(StudentDto student) {
		return session.update("hissafy.student.update", student);
	}

	@Override
	public StudentDto studentInfo(int student_id) {
		return session.selectOne("hissafy.student.selectOne",student_id);
	}

	@Override
	public List<StudentDto> studentList() {
		return session.selectList("hissafy.student.selectList");
	}

}
