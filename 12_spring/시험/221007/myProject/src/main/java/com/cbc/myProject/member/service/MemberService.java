package com.cbc.myProject.member.service;

import java.util.List;

import com.cbc.myProject.member.model.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> getSelectAll();
	public MemberDTO getSelectOne(MemberDTO paramDto);
	public int setInsert(MemberDTO paramDto);
	public int setUpdate(MemberDTO paramDto);
	public int setUpdatePasswd(MemberDTO paramDto);
	public int setDelete(MemberDTO paramDto);
	public int getIdCheck(MemberDTO paramDto);
	public int getPwCheck(MemberDTO paramDto);
	public int getSignIn(MemberDTO paramDto);
}//MemberService
