package com.cbc.springPortfolio.memo.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.springPortfolio.memo.model.dto.MemoDTO;

@Repository
public class MemoDAOImpl implements MemoDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemoDTO> getSelectAll(MemoDTO paramDto) {
		return sqlSession.selectList("memo.getSelectAll", paramDto);
	}//getSelectAll

	@Override
	public MemoDTO getSelectOne(MemoDTO paramDto) {
		return sqlSession.selectOne("memo.getSelectOne", paramDto);
	}//getSelectOne

	@Override
	public int setInsert(MemoDTO paramDto) {
		return sqlSession.insert("memo.setInsert", paramDto);
	}//setInsert

	@Override
	public int setUpdate(MemoDTO paramDto) {
		return sqlSession.update("memo.setUpdate", paramDto);
	}//setUpdate

	@Override
	public int setDelete(MemoDTO paramDto) {
		return sqlSession.delete("memo.setDelete", paramDto);
	}//setDelete

	@Override
	public int getTotalRecord(MemoDTO paramDto) {
		return sqlSession.selectOne("memo.getTotalRecord", paramDto);
	}//getTotalRecord

}//MemoDAOImpl
