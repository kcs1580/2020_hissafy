package com.web.hissafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.hissafy.service.IAttendanceService;
import com.web.hissafy.service.IStudentService;
import com.web.hisssafy.dto.StudentDto;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService sSer;
	
	@Autowired
	IAttendanceService aSer;


	@PostMapping("/registerstudent")
	@ApiOperation(value = "학생 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerBoard(@RequestBody List<StudentDto> studentList) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int cnt = sSer.studentListInsert(studentList);
		if (cnt>0) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "학생 정보 업데이트 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "학생 정보 업데이트  실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	@GetMapping("/studentlist")
	@ApiOperation(value ="학생리스트 조회 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> listBoard(){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<StudentDto> list = sSer.studentList();
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("resmsg", "학생 리스트 조회 성공");
			msg.put("list", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "학생 리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
}