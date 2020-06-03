package com.web.hissafy.repopsitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.hissafy.dto.EarlyLeaveDto;

@Repository
public class EarlyLeaveRepositoryImpl implements IEarlyLeaveRepository {
	@Autowired
	SqlSession session;

	@Override
	public int earlyInsert(EarlyLeaveDto earlyleave) {
		// TODO Auto-generated method stub
		return session.insert("hissafy.earlyleave.insert",earlyleave);
	}

	@Override
	public int earlyUpdate(EarlyLeaveDto earlyleave) {
		// TODO Auto-generated method stub
		return session.update("hissafy.earlyleave.update",earlyleave);
	}

	@Override
	public EarlyLeaveDto earlyInfo(String student_id) {
		// TODO Auto-generated method stub
		return session.selectOne("hissafy.earlyleave.selectOne",student_id);
	}

	@Override
	public List<EarlyLeaveDto> earlyList() {
		// TODO Auto-generated method stub
		return session.selectList("hissafy.earlyleave.selectList");
	}

	@Override
	public int earlyDelete(String student_id) {
		// TODO Auto-generated method stub
		return session.delete("hissafy.earlyleave.delete",student_id);
	}

}
