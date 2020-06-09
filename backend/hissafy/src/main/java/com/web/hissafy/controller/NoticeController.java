package com.web.hissafy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.hissafy.dto.EarlyLeaveDto;
import com.web.hissafy.dto.NoticeDto;
import com.web.hissafy.service.IEarlyLeaveService;
import com.web.hissafy.service.INoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/notice")
public class NoticeController {
	@Autowired
	INoticeService nSer;

	@PostMapping("/register")
	@ApiOperation(value = "공지사항 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerNotice(HttpServletRequest req) {
		String notice_title = req.getParameter("title");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String reg_date =req.getParameter("reg_date");
		
		String notice_img ="";
//		nSer.noticeInsert(new NoticeDto(notice_title, notice_img, start_date, end_date, reg_date))
		String realPath = req.getServletContext().getRealPath("/upload");
		File f = new File(realPath);
		System.out.println("realPath== "+realPath);
		if (!f.exists()) {// 경로가 없다면 폴더를 만든다.
			f.mkdir();
		}
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
		Iterator<String> fileNames = mhsr.getFileNames();
		if (!f.isDirectory()) {
			f.mkdir();
		}
		
		Map<String, Object> outData = new HashMap<String, Object>();
		try {
			while (fileNames.hasNext()) {
				String fileName = fileNames.next();
				MultipartFile file = mhsr.getFile(fileName);
				String oriName = new String(file.getOriginalFilename().getBytes("UTF-8"));
				String saveFileName = oriName; // 저장할 파일이름을 만드는데 뒤에 확장자도 붙임?
				File serverFile = new File(realPath + File.separator + saveFileName);
				file.transferTo(serverFile);
				map.put("uploaded", 1);
				map.put("url", req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload/"
						+ saveFileName);
				map.put("fileName", saveFileName);
				outData.put("uploaded", 1);
				outData.put("url", req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() 
						+ "/upload/" + saveFileName);
				outData.put("fileName", saveFileName);
				System.out.println(outData);
				System.out.println("!!!");
				notice_img=req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() 
				+ "/upload/" + saveFileName;
			}
			nSer.noticeInsert(new NoticeDto(notice_title, notice_img, start_date, end_date, reg_date));
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resEntity;
	}

	@GetMapping("/info/{notice_id}")
	@ApiOperation(value = "공지사항 조회")
	private @ResponseBody ResponseEntity<Map<String, Object>> infoEarlyleave(@PathVariable String notice_id) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			NoticeDto notice = nSer.noticeInfo(notice_id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "공지사항 조회 성공");
			map.put("notice", notice);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "공지사항 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/list")
	@ApiOperation(value = "조퇴 신청 리스트 조회", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> listNotice() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			List<NoticeDto> list = nSer.selectNoticeList();
			System.out.println(list.size());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "공지사항 리스트 조회 성공");
			map.put("list", list);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "공지사항 리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

	@PostMapping("/update")
	@ApiOperation(value = "공지사항 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateEarlyleave(@RequestBody NoticeDto notice) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int cnt = nSer.noticeUpdate(notice);
		if (cnt > 0) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 수정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;

	}

	@DeleteMapping("/delete/{notice_id}")
	@ApiOperation(value = "공지사항 삭제")
	private @ResponseBody ResponseEntity<Map<String, Object>> deleteEarlyleave(@PathVariable String notice_id) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int cnt = nSer.noticeDelete(notice_id);

		try {

			Map<String, Object> map = new HashMap<String, Object>();
			if (cnt > 0) {
				map.put("resmsg", "공지사항 삭제 성공");
			} else {
				map.put("resmsg", "공지사항 삭제 실패");
			}
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "공지사항 삭제 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

}
