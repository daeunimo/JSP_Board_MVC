package com.ja.board.model.vo;

import com.ja.board.model.dto.*;


public class ContentData {
	private ContentDTO contentDTO;
	private MemberDTO memberDTO;
	public ContentData(ContentDTO contentDTO, MemberDTO memberDTO) {
		super();
		this.contentDTO = contentDTO;
		this.memberDTO = memberDTO;
	}
	public ContentDTO getContentDTO() {
		return contentDTO;
	}
	public void setContentDTO(ContentDTO contentDTO) {
		this.contentDTO = contentDTO;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	
	
	
	
	
	
	
}
