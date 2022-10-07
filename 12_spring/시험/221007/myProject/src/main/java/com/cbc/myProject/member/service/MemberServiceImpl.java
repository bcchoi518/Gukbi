package com.cbc.myProject.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.myProject.member.model.dao.MemberDAO;
import com.cbc.myProject.member.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> getSelectAll() {
		return memberDao.getSelectAll();
	}//getSelectAll

	@Override
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		return memberDao.getSelectOne(paramDto);
	}//getSelectOne

	@Override
	public int setInsert(MemberDTO paramDto) {
		return memberDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(MemberDTO paramDto) {
		return memberDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setUpdatePasswd(MemberDTO paramDto) {
		return memberDao.setUpdatePasswd(paramDto);
	}//setUpdatePasswd

	@Override
	public int setDelete(MemberDTO paramDto) {
		return memberDao.setDelete(paramDto);
	}//setDelete

	@Override
	public int getIdCheck(MemberDTO paramDto) {
		return memberDao.getIdCheck(paramDto);
	}//getIdCheck

	@Override
	public int getPwCheck(MemberDTO paramDto) {
		return memberDao.getPwCheck(paramDto);
	}//getPwCheck

	@Override
	public int getSignIn(MemberDTO paramDto) {
		return memberDao.getSignIn(paramDto);
	}//getSignIn
}//MemberServiceImpl
