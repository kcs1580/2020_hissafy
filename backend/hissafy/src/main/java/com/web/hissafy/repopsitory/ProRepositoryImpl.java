package com.web.hissafy.repopsitory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.hissafy.dto.ProDto;

@Repository
public class ProRepositoryImpl implements IProRepository {
	
	@Autowired
	SqlSession session;

	@Override
	public int proInsert(ProDto pro) {
		return session.insert("hissafy.pro.insert",pro);
	}

	@Override
	public int proUpdate(ProDto pro) {
		return session.update("hissafy.pro.update", pro);
	}

	@Override
	public ProDto proInfo(String id) {
		return session.selectOne("hissafy.pro.selectOne",id);
	}

	@Override
	public ProDto loginPro(ProDto pro) {
		return session.selectOne("hissafy.pro.selectLogin", pro);
	}
	

}
