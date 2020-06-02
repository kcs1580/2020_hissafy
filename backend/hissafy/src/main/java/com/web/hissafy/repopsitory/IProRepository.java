package com.web.hissafy.repopsitory;

import com.web.hissafy.dto.ProDto;

public interface IProRepository {
	//프로 등록
	int proInsert(ProDto pro);
	//프로 정보 수정
	public int proUpdate(ProDto pro);
	//프로 정보
	public ProDto proInfo(String id);
	//프로 로그인
	ProDto loginPro(ProDto pro);
}
