package com.web.hissafy.service;

import com.web.hisssafy.dto.ProDto;

public interface JwtService {

	// 토큰 생성
	String create(ProDto pro);

	// 토큰 유효성 검증
	boolean validationToken(String jwt);

	// 토큰 만료 확인
	boolean getExpToken(String jwt);

	// 토큰으로부터 user_id 추출
	String getUserId(String jwt);

//	// 토큰으로부터 user_name추출
//	String getUserName(String jwt);
//
//	// 토큰으로부터 user_name추출
//	String getUserLocation(String jwt);

}
