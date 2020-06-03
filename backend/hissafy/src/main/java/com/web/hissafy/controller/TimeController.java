package com.web.hissafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.hissafy.dto.TimeDto;
import com.web.hissafy.service.ITimeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/time")
public class TimeController {
	
	@Autowired
	ITimeService tSer;
	

	@PostMapping("/registe")
	@ApiOperation(value = "시간 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerTime(@RequestBody TimeDto time) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int cnt = tSer.timeInsert(time);
		if (cnt>0) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "시간 설정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "시장 설정  실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	@GetMapping("/info")
	@ApiOperation(value ="설정 시간 조회 ")
	private @ResponseBody ResponseEntity<Map<String,Object>> infoTime(){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			TimeDto time = tSer.timeInfo(1);
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("resmsg", "설정 시간 조회 성공");
			msg.put("time", time);
			resEntity = new ResponseEntity<Map<String,Object>>(msg,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "설정 시간 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "설정 시간 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateTime(@RequestBody TimeDto time) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		System.out.println("update들어옴");
		int cnt = tSer.timeUpdate(time);
		System.out.println(time);
		if (cnt>0) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "시간 설정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "시간 설정  실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
}
