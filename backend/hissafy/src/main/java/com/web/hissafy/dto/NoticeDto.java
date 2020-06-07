package com.web.hissafy.dto;

public class NoticeDto {
	int notice_id ;
    String notice_title ;
    String notice_img;
    String start_date; 
    String end_date;
    String reg_date;
    public NoticeDto() {};
	public NoticeDto(int notice_id, String notice_title, String notice_img, String start_date, String end_date,
			String reg_date) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_img = notice_img;
		this.start_date = start_date;
		this.end_date = end_date;
		this.reg_date = reg_date;
	}
	public NoticeDto(String notice_title, String notice_img, String start_date, String end_date, String reg_date) {
		super();
		this.notice_title = notice_title;
		this.notice_img = notice_img;
		this.start_date = start_date;
		this.end_date = end_date;
		this.reg_date = reg_date;
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_img() {
		return notice_img;
	}
	public void setNotice_img(String notice_img) {
		this.notice_img = notice_img;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "NoticeDto [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_img=" + notice_img
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", reg_date=" + reg_date + "]";
	}
	
}
