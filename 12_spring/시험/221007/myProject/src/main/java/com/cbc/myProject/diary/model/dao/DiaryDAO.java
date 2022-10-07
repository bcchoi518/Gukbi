package com.cbc.myProject.diary.model.dao;

import java.util.List;

import com.cbc.myProject.diary.model.dto.DiaryDTO;

public interface DiaryDAO {
	public List<DiaryDTO> getSelectAll(DiaryDTO paramDto);
	public DiaryDTO getSelectOne(DiaryDTO paramDto);
	public int setInsert(DiaryDTO paramDto);
	public int setUpdate(DiaryDTO paramDto);
	public int setDelete(DiaryDTO paramDto);
	public int getTotalRecord(DiaryDTO paramDto);
}//DiaryDAO
