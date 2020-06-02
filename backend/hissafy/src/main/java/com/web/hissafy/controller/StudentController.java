package com.web.hissafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.web.hissafy.dto.StudentDto;
import com.web.hissafy.service.IAttendanceService;
import com.web.hissafy.service.IStudentService;
import com.web.hissafy.dto.AttendanceDto;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService sSer;

	@Autowired
	IAttendanceService aSer;

	@PutMapping("/updateAttendance")
	@ApiOperation(value = "attendance 정보를 받아 입퇴실 처리 서비스")
	public @ResponseBody ResponseEntity<Map<String, Object>> updateAttendance(@RequestBody AttendanceDto attendance) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> map = new HashMap<>();
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

////	교육생 등록
//	@PostMapping("/insertstudent")
//	@ApiOperation(value = "회원 등록")
//	private @ResponseBody ResponseEntity<Map<String, Object>> insertStudent(@PathVariable("u_index") int u_index) {
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		try {
//			int updateUser = 0;
//			Map<String, Object> map = new HashMap<String, Object>();
//
////			ProDto infoUser = pSer.proInfo(user_id);
////			map.put("uploaded", 1);
//			updateUser = sSer.proUpdate(user_id, user_pw, user_name, location);
//
//			if (updateUser > 0)
//				map.put("resmsg", "수정성공");
//			else
//				map.put("resmsg", "수정실패");
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//			return resEntity;
//
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("resmsg", "수정실패");
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//		}
//		return resEntity;
//	}
//	
//	@PostMapping("/signup")
//	@ApiOperation(value = "member 등록 서비스")
//	public @ResponseBody ResponseEntity<Map<String, Object>> registerMember(Member member,
//			HttpServletResponse response) {
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		Map<String, Object> map = new HashMap<>();
//		int insert = sSer.memberInsert(member);
//		member = sSer.memberInfo(member);
//		if (insert == 1) {
//			String token = jsvc.getAccessToken(member);
//			map.put("message", "회원 가입 성공");
//			response.addHeader("Authorization", token);
//			Token aToken = new Token();
//			aToken.setMemberid(member.getMemberid());
//			aToken.setEmail(member.getEmail());
//			aToken.setRefreshToken(token);
//			tsvc.insert(aToken);
//		} else {
//			map.put("message", "회원 가입 실패");
//		}
//		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//	}
//
//	@PutMapping("/update")
//	@ApiOperation(value = "member 수정 서비스")
//	public @ResponseBody ResponseEntity<Map<String, Object>> updateMember(Member member) {
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		Map<String, Object> map = new HashMap<>();
//		try {
//			int update = msvc.memberUpdate(member);
//			map.put("result", update);
//			map.put("isupdate", true);
//		} catch (RuntimeException e) {
//			map.put("isupdate", "회원정보 수정 실패");
//		}
//		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/delete")
//	@ApiOperation(value = "멤버 삭제")
//	public ResponseEntity<Map<String, Object>> deleteMember(Member member) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			msvc.memberDelete(member);
//			map.put("message", "회원 탈퇴 성공");
//		} catch (RuntimeException e) {
//			map.put("message", "회원 탈퇴 실패");
//		}
//		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//	}
//
//	@PostMapping("/info")
//	@ApiOperation(value = "id를 받아 member 조회 서비스", response = Member.class)
//	public @ResponseBody ResponseEntity<Map<String, Object>> infoMember(Member member) {
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			member = msvc.memberInfo(member);
//			member.setPw("");
//			map.put("message", "success");
//			map.put("result", member);
//		} catch (RuntimeException e) {
//			map.put("message", "fail");
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//	}
//
//	@GetMapping("/list")
//	@ApiOperation("회원 목록 조회 서비스")
//	public @ResponseBody ResponseEntity<Map<String, Object>> listMember() {
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		List<Member> list = null;
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			map.put("message", "회원 목록 조회 성공");
//			map.put("result", msvc.memberList());
//		} catch (RuntimeException e) {
//			map.put("message", "회원 목록 조회 실패");
//		}
//		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//	}
//	
//	
//	
//	
//	
//	
//
//	
////	회원정보 
//	@GetMapping("/infopro")
//	@ApiOperation(value = "회원정보 조회", response = ProDto.class)
//	private @ResponseBody ResponseEntity<Map<String, Object>> infoUserbyIndex(@PathVariable("u_index") int u_index) {
//		System.out.println(u_index);
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		ProDto user = null;
//		try {
////			user = pSer.proInfo(id);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("resmsg", "조회성공");
//			map.put("resvalue", user);
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//		} catch (RuntimeException e) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("resmsg", "조회실패");
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//		}
//		return resEntity;
//
//	}
//
////	회원정보 update
//	@PutMapping("/updatepro")
//	@ApiOperation(value = "회원정보 수정")
//	private ResponseEntity<Map<String, Object>> updateMem(HttpServletRequest req) {
//
//		String user_id = req.getParameter("user_id");
//		String user_pw = req.getParameter("user_pw");
//		String user_name = req.getParameter("user_name");
//		String location = req.getParameter("location");
//		ResponseEntity<Map<String, Object>> resEntity = null;
//		try {
//			int updateUser = 0;
//			Map<String, Object> map = new HashMap<String, Object>();
//
////			ProDto infoUser = pSer.proInfo(user_id);
////			map.put("uploaded", 1);
//			updateUser = pSer.proUpdate(user_id, user_pw, user_name, location);
//
//			if (updateUser > 0)
//				map.put("resmsg", "수정성공");
//			else
//				map.put("resmsg", "수정실패");
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//			return resEntity;
//
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("resmsg", "수정실패");
//			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//		}
//		return resEntity;
//	}

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
}