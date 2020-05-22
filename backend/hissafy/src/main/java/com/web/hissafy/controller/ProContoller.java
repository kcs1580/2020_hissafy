package com.web.hissafy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.hissafy.service.IProService;
import com.web.hisssafy.dto.ProDto;

import io.swagger.annotations.ApiOperation;
@Controller
public class ProContoller {

	@Autowired
	IProService pSer;

//	로그인
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	private @ResponseBody ResponseEntity<Map<String, Object>> signUpPro(@RequestBody ProDto pro,
			HttpServletRequest req) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		ProDto loginPro = null;
		String token = null;// Jwt 사용

		try {
			loginPro = pSer.loginPro(pro.getUser_id(), pro.getUser_pw());
//			token=jwtService.create(loginPro);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "로그인 성공");
			map.put("resvalue", token);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "로그인 실패");
			map.put("resvalue", loginPro);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		}
		return resEntity;

	}

//	회원정보 
	@GetMapping("/infopro")
	@ApiOperation(value = "회원정보 조회", response = ProDto.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> infoUserbyIndex(@PathVariable("u_index") int u_index) {
		System.out.println(u_index);
		ResponseEntity<Map<String, Object>> resEntity = null;
		ProDto user = null;
		try {
//			user = pSer.proInfo(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회성공");
			map.put("resvalue", user);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;

	}

//	회원정보 update
	@PutMapping("/updatepro")
	@ApiOperation(value = "회원정보 수정")
	private ResponseEntity<Map<String, Object>> updateMem(HttpServletRequest req) {

		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String user_name = req.getParameter("user_name");
		String location = req.getParameter("location");
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int updateUser = 0;
			Map<String, Object> map = new HashMap<String, Object>();

//			ProDto infoUser = pSer.proInfo(user_id);
//			map.put("uploaded", 1);
			updateUser = pSer.proUpdate(user_id, user_pw, user_name, location);

			if (updateUser > 0)
				map.put("resmsg", "수정성공");
			else
				map.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			return resEntity;

		} catch (RuntimeException e) {
			System.out.println(e);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
