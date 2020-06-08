package com.web.hissafy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.hissafy.dto.EarlyLeaveDto;
import com.web.hissafy.service.IEarlyLeaveService;
import com.web.hissafy.service.IStudentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/earlyleave")

public class EarlyLeaveController {

	@Autowired
	IEarlyLeaveService eSer;

	@PostMapping("/registerearlyleave")
	@ApiOperation(value = "조퇴 신청 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerEarlyleave(
			@RequestBody EarlyLeaveDto earlyleave) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		String earlyleave_date = date_format.format(new Date());
		earlyleave.setEarlyleave_date(earlyleave_date);
		System.out.println(earlyleave.getEarlyleave_date());
		int cnt = eSer.earlyInsert(earlyleave);
		if (cnt > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조퇴 신청 등록 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조퇴 신청 등록 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;

	}

	@GetMapping("/infoearlyleave/{student_id}/{earlyleave_date}")
	@ApiOperation(value = "조퇴 신청 조회", response = EarlyLeaveDto.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> infoEarlyleave(@PathVariable String student_id, @PathVariable String earlyleave_date){
		ResponseEntity<Map<String,Object>> resEntity= null;
		try {
			EarlyLeaveDto earlyleave = eSer.earlyInfo(new EarlyLeaveDto(student_id, earlyleave_date));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resmsg", "조퇴 신청 조회 성공");
			map.put("earlyleave",earlyleave);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조퇴 신청 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
	
	@GetMapping("/earlyleavelist")
	@ApiOperation(value = "조퇴 신청 리스트 조회", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> listEarlyleave(){
		ResponseEntity<Map<String,Object>> resEntity= null;
		try {
			List<EarlyLeaveDto> list = eSer.earlyList();
			System.out.println(list.size());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resmsg", "조퇴 신청 리스트 조회 성공");
			map.put("list",list);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조퇴 신청 리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
	
	@GetMapping("/earlyleavelist/{earlyleave_date}")
	@ApiOperation(value = "조퇴 신청 날짜별 리스트 조회", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> listEarlyleave(@PathVariable String earlyleave_date){
		ResponseEntity<Map<String,Object>> resEntity= null;
		System.out.println(earlyleave_date);
		try {
			
			List<EarlyLeaveDto> list = eSer.earlyDateList(earlyleave_date);
			
			System.out.println(list.size());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resmsg", "조퇴 신청 리스트 조회 성공");
			map.put("list",list);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조퇴 신청 리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
	
	@PostMapping("/updateearlyleave")
	@ApiOperation(value = "조퇴 신청 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateEarlyleave(
			@RequestBody EarlyLeaveDto earlyleave) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int cnt = eSer.earlyUpdate(earlyleave);
		if (cnt > 0) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "조퇴 신청 수정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "조퇴 신청 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;

	}
	
	
	@DeleteMapping("/deleteearlyleave/{student_id}")
	@ApiOperation(value ="조퇴 신청 삭제")
	private @ResponseBody ResponseEntity<Map<String,Object>> deleteEarlyleave(@PathVariable String student_id){
		ResponseEntity<Map<String,Object>> resEntity= null;
		try {
			SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
			String earlyleave_date = date_format.format(new Date());
			EarlyLeaveDto earlyleave = eSer.earlyInfo(new EarlyLeaveDto(student_id,earlyleave_date));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resmsg", student_id+" 조퇴 신청 삭제 성공");
			map.put("earlyleave",earlyleave);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg",student_id+" 조퇴 신청 삭제 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	

}
