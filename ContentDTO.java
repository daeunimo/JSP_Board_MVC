package com.ja.board.model.dto;

public class ContentDTO {
	private String c_idx;
	private String m_idx;
	private String c_title;
	private String c_content;
	private String c_count;
	private String c_writedate;
	public ContentDTO(String c_idx, String m_idx, String c_title, String c_content, String c_count,
			String c_writedate) {
		super();
		this.c_idx = c_idx;
		this.m_idx = m_idx;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_count = c_count;
		this.c_writedate = c_writedate;
	}
	public String getC_idx() {
		return c_idx;
	}
	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_count() {
		return c_count;
	}
	public void setC_count(String c_count) {
		this.c_count = c_count;
	}
	public String getC_writedate() {
		return c_writedate;
	}
	public void setC_writedate(String c_writedate) {
		this.c_writedate = c_writedate;
	}
	
	
	
	
}
