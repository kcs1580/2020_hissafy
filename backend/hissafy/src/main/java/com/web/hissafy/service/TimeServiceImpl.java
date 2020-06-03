package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.dto.TimeDto;
import com.web.hissafy.repopsitory.ITimeRepository;

@Service
public class TimeServiceImpl implements ITimeService{

	@Autowired
	ITimeRepository repo;
	
	@Override
	public TimeDto timeInfo(int time_id) {		
		return repo.timeInfo(time_id);
	}

	@Override
	public List<TimeDto> timeList() {
		return repo.timeList();
	}

	@Override
	public int timeInsert(TimeDto time) {
		return repo.timeInsert(time);
	}

	@Override
	public int timeUpdate(TimeDto time) {
		int timeCnt =timeList().size();
		if(timeCnt==0) {
			return timeInsert(time);
		}else {
			return repo.timeUpdate(time);
		}
		
	}

}
