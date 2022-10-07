package com.cbc.myProject.member.model.dao;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.myProject.member.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> getSelectAll() {
		return sqlSession.selectList("member.getSelectAll");
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
	public int setUpdatePasswd(MemberDTO paramDto) {
		return sqlSession.update("member.setUpdatePasswd", paramDto);
	}//setUpdatePasswd

	@Override
	public int setDelete(MemberDTO paramDto) {
		return sqlSession.delete("member.setDelete", paramDto);
	}//setDelete

	@Override
	public int getIdCheck(MemberDTO paramDto) {
		return sqlSession.selectOne("member.getIdCheck", paramDto);
	}//getIdCheck

	@Override
	public int getPwCheck(MemberDTO paramDto) {
		return sqlSession.selectOne("member.getPwCheck", paramDto);
	}//getPwCheck

	@Override
	public int getSignIn(MemberDTO paramDto) {
		Optional<Object> opt = Optional.ofNullable(sqlSession.selectOne("member.getSignIn", paramDto));
		return (int) opt.orElse(0);
	}//getSignIn
}//MemberDAOImpl
