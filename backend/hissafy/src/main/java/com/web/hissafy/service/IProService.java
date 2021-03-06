package com.web.hissafy.service;

import com.web.hissafy.dto.ProDto;

public interface IProService {
	// 프로 등록
	public int proInsert(String user_id, String user_pw, String user_name, String location);
	
	// 프로 정보 수정
	public int proUpdate(String user_id, String user_pw, String user_name, String location);
	
	// 프로 정보
	public ProDto proInfo(String id);
	
	// 프로 로그인
	public ProDto loginPro(String user_id, String user_pw);
}
