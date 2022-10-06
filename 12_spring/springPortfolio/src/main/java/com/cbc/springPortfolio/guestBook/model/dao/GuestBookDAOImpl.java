package com.cbc.springPortfolio.guestBook.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.springPortfolio.guestBook.model.dto.GuestBookDTO;

@Repository
public class GuestBookDAOImpl implements GuestBookDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<GuestBookDTO> getSelectAll(GuestBookDTO paramDto) {
		return sqlSession.selectList("guestBook.getSelectAll", paramDto);
	}//getSelectAll

	@Override
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto) {
		return sqlSession.selectOne("guestBook.getSelectOne", paramDto);
	}//getSelectOne

	@Override
	public int setInsert(GuestBookDTO paramDto) {
		return sqlSession.insert("guestBook.setInsert", paramDto);
	}//setInsert

	@Override
	public int setUpdate(GuestBookDTO paramDto) {
		return sqlSession.update("guestBook.setUpdate", paramDto);
	}//setUpdate

	@Override
	public int setDelete(GuestBookDTO paramDto) {
		return sqlSession.delete("guestBook.setDelete", paramDto);
	}//setDelete
	
	@Override
	public int getTotalRecord(GuestBookDTO paramDto) {
		return sqlSession.selectOne("guestBook.getTotalRecord", paramDto);
	}//getTotalRecord
}//GuestBookDAOImpl
