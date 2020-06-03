package com.web.hissafy.repopsitory;

import java.util.List;

import com.web.hissafy.dto.TimeDto;

public interface ITimeRepository {
	public int timeInsert(TimeDto time);
	public int timeUpdate(TimeDto time);
	public TimeDto timeInfo(int time_id); 
	public List<TimeDto> timeList();
}
