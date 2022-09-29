package project.guestBookMybatis.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import project._mybatisConfig.MybatisManager;
import project.guestBookMybatis.model.dto.GuestBookMybatisDTO;

public class GuestBookMybatisDAO {
	private String tableName01 = "guestBook";
	
	public int getTotalRecord(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("guestBookMybatis.getTotalRecord", map);
		session.close();
		
		return result;
	}//getTotalRecord
	
	public List<GuestBookMybatisDTO> getSelectAll(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		List<GuestBookMybatisDTO> list = session.selectList("guestBookMybatis.getSelectAll", map);
		session.close();
		
		return list;
	}//getSelectAll
	
	public GuestBookMybatisDTO getSelectOne(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		GuestBookMybatisDTO dto = session.selectOne("guestBookMybatis.getSelectOne", map);
		session.close();
		
		return dto;
	}//getSelectOne
	
	public int setInsert(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("guestBookMybatis.setInsert", map);
		session.commit();
		session.close();
		
		return result;
	}//setInsert
	
	public int setUpdate(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.update("guestBookMybatis.setUpdate", map);
		session.commit();
		session.close();
		
		return result;
	}//setUpdate
	
	public int setDelete(GuestBookMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.delete("guestBookMybatis.setDelete", map);
		session.commit();
		session.close();
		
		return result;
	}//setDelete
}//GuestBookMybatisDAO
