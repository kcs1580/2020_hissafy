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

import com.web.hissafy.service.IAttendanceService;
import com.web.hissafy.service.IStudentService;

import io.swagger.annotations.ApiOperation;

@Controller
public class StudentController {

	@Autowired
	IStudentService sSer;
	
	@Autowired
	IAttendanceService aSer;


}