package com.web.hissafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.repopsitory.IProRepository;
import com.web.hisssafy.dto.ProDto;

@Service
public class ProServiceImpl implements IProService {

	@Autowired
	IProRepository repo;
	
	@Override
	public int proInsert(String user_id, String user_pw, String user_name, String location) {
		return repo.proInsert(new ProDto(user_id, user_pw, user_name, location));
	}

	@Override
	public int proUpdate(String user_id, String user_pw, String user_name, String location) {
		return repo.proUpdate(new ProDto(user_id, user_pw, user_name, location));
	}

	@Override
	public ProDto proInfo(String id) {
		return repo.proInfo(id);
	}

	@Override
	public ProDto loginPro(String user_id, String user_pw) {
		return repo.loginPro(new ProDto(user_id, user_pw));
	}

}
