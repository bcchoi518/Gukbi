package com.cbc.springPortfolio.member.service;

import java.util.List;

import com.cbc.springPortfolio.member.model.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> getSelectAll(MemberDTO paramDto);
	public MemberDTO getSelectOne(MemberDTO paramDto);
	public int setInsert(MemberDTO paramDto);
	public int setUpdate(MemberDTO paramDto);
	public int setDelete(MemberDTO paramDto);
	public int getIdCheck(MemberDTO paramDto);
	public int getTotalRecord(MemberDTO paramDto);
}//MemberService
