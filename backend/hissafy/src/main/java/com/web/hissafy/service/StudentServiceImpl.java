package com.web.hissafy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.dto.StudentDto;
import com.web.hissafy.repopsitory.IStudentRepository;

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
		System.out.println("list=======================================");
		List<StudentDto> getList = studentList();
		HashMap<String, StudentDto> hash = new HashMap<>();
		int cnt = 0;

		for (int i = 0; i < getList.size(); i++) {
			hash.put(getList.get(i).getStudent_id(), getList.get(i));
			System.out.println(getList.get(i).getStudent_id());
		}
		for (int i = 0; i < list.size(); i++) {
			StudentDto student = list.get(i);
			System.out.println(student.getStudent_id());
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
	public StudentDto studentInfo(String id) {
		return repo.studentInfo(id);
	}

	@Override
	public List<StudentDto> studentList() {
		return repo.studentList();
	}

}
