package com.web.hissafy.dto;

public class EarlyLeaveDto {

	private String student_id;
	private String earlyleave_date;
	public EarlyLeaveDto(String student_id, String earlyleave_date, String division, String sort, String reason,
			String leaving_time, String approval_state) {
		super();
		this.student_id = student_id;
		this.earlyleave_date = earlyleave_date;
		this.division = division;
		this.sort = sort;
		this.reason = reason;
		this.leaving_time = leaving_time;
		this.approval_state = approval_state;
	}
	public EarlyLeaveDto(String student_id, String earlyleave_date) {
		super();
		this.student_id = student_id;
		this.earlyleave_date = earlyleave_date;
	}
	public String getEarlyleave_date() {
		return earlyleave_date;
	}

	public void setEarlyleave_date(String earlyleave_date) {
		this.earlyleave_date = earlyleave_date;
	}

	private String division;
	private String sort;
	private String reason;
	private String leaving_time;
	private String approval_state;

	public EarlyLeaveDto(String student_id, String division, String sort, String reason, String leaving_time,
			String approval_state) {
		super();
		this.student_id = student_id;
		this.division = division;
		this.sort = sort;
		this.reason = reason;
		this.leaving_time = leaving_time;
		this.approval_state = approval_state;
	}

	public EarlyLeaveDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLeaving_time() {
		return leaving_time;
	}

	public void setLeaving_time(String leaving_time) {
		this.leaving_time = leaving_time;
	}

	public String getApproval_state() {
		return approval_state;
	}

	public void setApproval_state(String approval_state) {
		this.approval_state = approval_state;
	}
	
	@Override
	public String toString() {
		return "EarlyLeaveDto [student_id=" + student_id + ", earlyleave_date=" + earlyleave_date + ", division="
				+ division + ", sort=" + sort + ", reason=" + reason + ", leaving_time=" + leaving_time
				+ ", approval_state=" + approval_state + "]";
	}

}
