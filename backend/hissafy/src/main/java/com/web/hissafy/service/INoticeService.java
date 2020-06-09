package com.web.hissafy.service;

import java.util.List;

import com.web.hissafy.dto.NoticeDto;

public interface INoticeService {
	int noticeInsert(NoticeDto notice);
	int noticeUpdate(NoticeDto notice);
	int noticeDelete(String notice_id);
	NoticeDto noticeInfo(String notice_id);
	List<NoticeDto> selectNoticeList();
}
