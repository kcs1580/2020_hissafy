package com.web.hissafy.repopsitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.hissafy.dto.NoticeDto;

@Repository
public class NoticeRepositoryImpl implements INoticeRepository{
	@Autowired
	SqlSession session;

	@Override
	public int noticeInsert(NoticeDto notice) {
		return session.insert("hissafy.notice.insert", notice);
	}

	@Override
	public int noticeUpdate(NoticeDto notice) {
		return session.update("hissafy.notice.update",notice);
	}

	@Override
	public int noticeDelete(int notice_id) {
		return session.delete("hissafy.notice.delete",notice_id);
	}

	@Override
	public NoticeDto noticeInfo(int notice_id) {
		return session.selectOne("hissafy.notice.selectOne",notice_id);
	}

	@Override
	public List<NoticeDto> selectNoticeList() {
		return session.selectList("hissafy.notice.selectList");
	}

}
