package com.web.hissafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hissafy.dto.NoticeDto;
import com.web.hissafy.repopsitory.INoticeRepository;

@Service
public class NoticeServiceImpl implements INoticeService{
	
	@Autowired
	INoticeRepository repo;
	
	@Override
	public int noticeInsert(NoticeDto notice) {
		return repo.noticeInsert(notice);
	}

	@Override
	public int noticeUpdate(NoticeDto notice) {
		return repo.noticeUpdate(notice);
	}

	@Override
	public int noticeDelete(String notice_id) {
		int id = Integer.parseInt(notice_id);
		return repo.noticeDelete(id);
	}

	@Override
	public NoticeDto noticeInfo(String notice_id) {
		int id = Integer.parseInt(notice_id);
		return repo.noticeInfo(id);
	}

	@Override
	public List<NoticeDto> selectNoticeList() {
		return repo.selectNoticeList();
	}

}
