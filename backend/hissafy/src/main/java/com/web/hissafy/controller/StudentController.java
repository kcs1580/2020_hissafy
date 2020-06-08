package com.web.hissafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.hissafy.dto.StudentDto;
import com.web.hissafy.service.IAttendanceService;
import com.web.hissafy.service.IStudentService;
import com.web.hissafy.dto.AttendanceDto;
import com.web.hissafy.dto.DuringStudentDto;
import com.web.hissafy.dto.EarlyLeaveDto;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService sSer;

	@Autowired
	IAttendanceService aSer;
	
	@GetMapping("/infoAttendance/{student_id}")
	@ApiOperation(value = "학번으로 오늘 출석 조회", response = EarlyLeaveDto.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> infoEarlyleave(@PathVariable String student_id){
		ResponseEntity<Map<String,Object>> resEntity= null;
		try {
			AttendanceDto attendance = aSer.attendanceInfo(student_id);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resmsg", "출석 조회 성공");
			map.put("attendance",attendance);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "출석 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	@PutMapping("/updateAttendance")
	@ApiOperation(value = "attendance 정보를 받아 입퇴실 처리 서비스")
	public @ResponseBody ResponseEntity<Map<String, Object>> updateAttendance(@RequestBody AttendanceDto attendance) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> map = new HashMap<>();
		System.out.println(attendance);
		try {
			if (attendance.getAttendance_state().equals("입실완료")) {
				int update = aSer.attendanceUpdateAttendance(attendance);
				map.put("result", "반환값이 있으면 넣기");
				map.put("message", update + "명 입실 처리 완료");
			} else if (attendance.getAttendance_state().equals("퇴실완료")) {
				int update = aSer.attendanceUpdateLeaving(attendance);
				map.put("result", "반환값이 있으면 넣기");
				map.put("message", update + "명 퇴실 처리 완료");
			}
		} catch (RuntimeException e) {
			map.put("message", "입퇴실 업데이트 실패");
		}
		resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return resEntity;
	}
	@GetMapping("/Attendance/{date}")
	@ApiOperation(value = "attendance 날짜별 리스트")
	public @ResponseBody ResponseEntity<Map<String, Object>> getAttendance(@PathVariable String date) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> map = new HashMap<>();
		try {
			List<AttendanceDto> list = aSer.attendanceDateList(date);
			map.put("list", list);
			map.put("message", "조회 성공");
		} catch (RuntimeException e) {
			map.put("message", "조회 실패 성공");
		}
		resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return resEntity;
	}
	

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
			System.out.println(list.size());
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
	
	@GetMapping("/studentduringlist")
	@ApiOperation(value ="학생리스트 조회 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> listDuringStudent(){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<DuringStudentDto> list = sSer.studentDuringList();
			System.out.println("입과중인 학생 " + list.size() + "명 조회 성공");
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("message", "입과중인 학생 리스트 조회 성공");
			msg.put("result", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("message", "입과중인 학생 리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
}