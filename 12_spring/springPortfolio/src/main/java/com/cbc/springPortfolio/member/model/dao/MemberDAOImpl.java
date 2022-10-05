package com.cbc.springPortfolio.member.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.springPortfolio.member.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> getSelectAll(MemberDTO paramDto) {
		return sqlSession.selectList("member.getSelectAll", paramDto);
	}//getSelectAll

	@Override
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		return sqlSession.selectOne("member.getSelectOne", paramDto);
	}//getSelectOne

	@Override
	public int setInsert(MemberDTO paramDto) {
		return sqlSession.insert("member.setInsert", paramDto);
	}//setInsert

	@Override
	public int setUpdate(MemberDTO paramDto) {
		return sqlSession.update("member.setUpdate", paramDto);
	}//setUpdate

	@Override
	public int setDelete(MemberDTO paramDto) {
		return sqlSession.delete("member.setDelete", paramDto);
	}//setDelete

	@Override
	public int getIdCheck(MemberDTO paramDto) {
		return sqlSession.selectOne("member.getIdCheck", paramDto);
	}//getIdCheck

	@Override
	public int getTotalRecord(MemberDTO paramDto) {
		return sqlSession.selectOne("member.getTotalRecord", paramDto);
	}//getTotalRecord
}//MemberDAOImpl
