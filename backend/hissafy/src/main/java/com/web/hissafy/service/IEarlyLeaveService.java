package com.web.hissafy.service;

import java.util.List;

import com.web.hissafy.dto.EarlyLeaveDto;

public interface IEarlyLeaveService {

	public int earlyInsert(EarlyLeaveDto earlyleave);

	public int earlyUpdate(EarlyLeaveDto earlyleave);

	public EarlyLeaveDto earlyInfo(EarlyLeaveDto earlyleave);

	public List<EarlyLeaveDto> earlyList();
	
	public List<EarlyLeaveDto> earlyDateList(String date);
	
	public int earlyDelete (String student_id);

}
