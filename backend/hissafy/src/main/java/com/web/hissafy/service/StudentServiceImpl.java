package com.web.hissafy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.repopsitory.IStudentRepository;
import com.web.hisssafy.dto.StudentDto;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository repo;

	@Override
	public int studentInsert(String student_id, String area, int group_num, int class_num, String name, String state,
			String face_id) {
		return repo.studentInsert(new StudentDto(student_id, area, group_num, class_num, name, state, face_id));
	}

	@Override
	public int studentListInsert(List<StudentDto> list) {
		List<StudentDto> getList = studentList();
		HashMap<String, StudentDto> hash = new HashMap<>();
		int cnt = 0;

		for (int i = 0; i < getList.size(); i++) {
			hash.put(getList.get(i).getStudent_id(), getList.get(i));
		}
		StudentDto student = null;
		for (int i = 0; i < list.size(); i++) {
			student = list.get(i);
			if (hash.containsKey(student.getStudent_id())) {
				cnt += studentUpdate(student.getStudent_id(), student.getArea(), student.getGroup_num(),
						student.getClass_num(), student.getName(), student.getState(), student.getFace_id());
			} else {
				cnt += studentInsert(student.getStudent_id(), student.getArea(), student.getGroup_num(),
						student.getClass_num(), student.getName(), student.getState(), student.getFace_id());
			}
		}

		return cnt;
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
