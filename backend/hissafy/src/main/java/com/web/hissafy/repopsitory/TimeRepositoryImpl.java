package com.web.hissafy.repopsitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.hissafy.dto.TimeDto;

@Repository
public class TimeRepositoryImpl implements ITimeRepository{
	
	@Autowired
	SqlSession session;
	@Override
	public int timeInsert(TimeDto time) {
		return session.insert("hissafy.time.insert",time);
	}

	@Override
	public int timeUpdate(TimeDto time) {
		System.out.println("time repository update===== ");
		time.setTime_id(1);
		return session.update("hissafy.time.update",time);
		
	}

	@Override
	public TimeDto timeInfo(int time_id) {
		return session.selectOne("hissafy.time.selectOne",time_id);
	}

	@Override
	public List<TimeDto> timeList() {
		return session.selectList("hissafy.time.selectList");
	}

	
}
