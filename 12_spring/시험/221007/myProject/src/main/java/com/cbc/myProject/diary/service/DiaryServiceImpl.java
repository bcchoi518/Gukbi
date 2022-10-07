package com.cbc.myProject.diary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.myProject.diary.model.dao.DiaryDAO;
import com.cbc.myProject.diary.model.dto.DiaryDTO;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Inject
	DiaryDAO diaryDao;
	
	@Override
	public List<DiaryDTO> getSelectAll(DiaryDTO paramDto) {
		return diaryDao.getSelectAll(paramDto);
	}//getSelectAll

	@Override
	public DiaryDTO getSelectOne(DiaryDTO paramDto) {
		return diaryDao.getSelectOne(paramDto);
	}//getSelectOne

	@Override
	public int setInsert(DiaryDTO paramDto) {
		return diaryDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(DiaryDTO paramDto) {
		return diaryDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setDelete(DiaryDTO paramDto) {
		return diaryDao.setDelete(paramDto);
	}//setDelete
	
	@Override
	public int getTotalRecord(DiaryDTO paramDto) {
		return diaryDao.getTotalRecord(paramDto);
	}//getTotalRecord
}//DiaryServiceImpl
