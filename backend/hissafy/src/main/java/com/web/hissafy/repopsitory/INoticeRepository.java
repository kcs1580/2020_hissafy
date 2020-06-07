package com.web.hissafy.repopsitory;

import java.util.List;

import com.web.hissafy.dto.NoticeDto;

public interface INoticeRepository {
	int noticeInsert(NoticeDto notice);
	int noticeUpdate(NoticeDto notice);
	int noticeDelete(int notice_id);
	NoticeDto noticeInfo(int notice_id);
	List<NoticeDto> selectNoticeList();
	
}
