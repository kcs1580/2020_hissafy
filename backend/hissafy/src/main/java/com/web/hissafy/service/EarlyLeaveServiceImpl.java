package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.dto.EarlyLeaveDto;
import com.web.hissafy.repopsitory.IEarlyLeaveRepository;

@Service
public class EarlyLeaveServiceImpl implements IEarlyLeaveService {

	@Autowired
	IEarlyLeaveRepository repo;

	@Override
	public int earlyInsert(EarlyLeaveDto earlyleave) {
		// TODO Auto-generated method stub
		return repo.earlyInsert(earlyleave);
	}

	@Override
	public int earlyUpdate(EarlyLeaveDto earlyleave) {
		// TODO Auto-generated method stub
		return repo.earlyUpdate(earlyleave);
	}

	@Override
	public EarlyLeaveDto earlyInfo(EarlyLeaveDto earlyleave) {
		// TODO Auto-generated method stub
		return repo.earlyInfo(earlyleave);
	}

	@Override
	public List<EarlyLeaveDto> earlyList() {
		// TODO Auto-generated method stub
		return repo.earlyList();
	}

	@Override
	public int earlyDelete(String student_id) {
		// TODO Auto-generated method stub
		return repo.earlyDelete(student_id);
	}

	@Override
	public List<EarlyLeaveDto> earlyDateList(String date) {
		return repo.earlyDateList(date);
	}

}
