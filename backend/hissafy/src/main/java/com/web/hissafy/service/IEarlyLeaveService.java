package com.web.hissafy.service;

import java.util.List;

import com.web.hissafy.dto.EarlyLeaveDto;

public interface IEarlyLeaveService {

	public int earlyInsert(EarlyLeaveDto earlyleave);

	public int earlyUpdate(EarlyLeaveDto earlyleave);

	public EarlyLeaveDto earlyInfo(String student_id);

	public List<EarlyLeaveDto> earlyList();
	
	public int earlyDelete (String student_id);

}
