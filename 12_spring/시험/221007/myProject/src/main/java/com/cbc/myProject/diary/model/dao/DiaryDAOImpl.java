package com.cbc.myProject.diary.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.myProject.diary.model.dto.DiaryDTO;

@Repository
public class DiaryDAOImpl implements DiaryDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<DiaryDTO> getSelectAll(DiaryDTO paramDto) {
		return sqlSession.selectList("diary.getSelectAll", paramDto);
	}//getSelectAll

	@Override
	public DiaryDTO getSelectOne(DiaryDTO paramDto) {
		return sqlSession.selectOne("diary.getSelectOne", paramDto);
	}//getSelectOne

	@Override
	public int setInsert(DiaryDTO paramDto) {
		return sqlSession.insert("diary.setInsert", paramDto);
	}//setInsert

	@Override
	public int setUpdate(DiaryDTO paramDto) {
		return sqlSession.update("diary.setUpdate", paramDto);
	}//setUpdate

	@Override
	public int setDelete(DiaryDTO paramDto) {
		return sqlSession.delete("diary.setDelete", paramDto);
	}//setDelete
	
	@Override
	public int getTotalRecord(DiaryDTO paramDto) {
		return sqlSession.selectOne("diary.getTotalRecord", paramDto);
	}//getTotalRecord
}//DiaryDAOImpl
