package com.cbc.springPortfolio.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.springPortfolio.member.model.dao.MemberDAO;
import com.cbc.springPortfolio.member.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> getSelectAll(MemberDTO paramDto) {
		return memberDao.getSelectAll(paramDto);
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
	public int setDelete(MemberDTO paramDto) {
		return memberDao.setDelete(paramDto);
	}//setDelete

	@Override
	public int getIdCheck(MemberDTO paramDto) {
		return memberDao.getIdCheck(paramDto);
	}//getIdCheck

	@Override
	public int getTotalRecord(MemberDTO paramDto) {
		return memberDao.getTotalRecord(paramDto);
	}//getTotalRecord
}//MemberServiceImpl
