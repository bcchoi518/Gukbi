package project.memoMybatis.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import project._mybatisConfig.MybatisManager;
import project.memoMybatis.model.dto.MemoMybatisDTO;

public class MemoMybatisDAO {
	String tableName01 = "memo";
	
	public int getTotalRecord(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
		int result = session.selectOne("memoMybatis.getTotalRecord", map);
		session.close();
		
		return result;
	}//getTotalRecord
	
	//mybatis에서 ArrayList 타입을 선언하면 에러발생!(부모타입 선언 후 자식객체를 생성)
	public List<MemoMybatisDTO> getSelectAll(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
		List<MemoMybatisDTO> list = session.selectList("memoMybatis.getSelectAll", map);
		session.close();
		
		return list;
	}//getSelectAll
	
	public MemoMybatisDTO getSelectOne(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
		MemoMybatisDTO memoMybatisDto = session.selectOne("memoMybatis.getSelectOne", map);
		session.close();
		
		return memoMybatisDto;
	}//getSelectOne
	
	public int setInsert(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
//		int result = session.insert("네임스페이스.태그아이디","물고갈 값"); 물고갈 값은 1개만 넘길 수 있음
		int result = session.insert("memoMybatis.setInsert", map);
		session.commit();
		session.close();
		
		return result;
	}//setInsert
	
	public int setUpdate(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
		int result = session.update("memoMybatis.setUpdate", map);
		session.commit();
		session.close();
		
		return result;
	}//setUpdate
	
	public int setDelete(MemoMybatisDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName01", tableName01);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession(); //import org.apache.ibatis.session.SqlSession;
		int result = session.delete("memoMybatis.setDelete", map);
		session.commit();
		session.close();
		
		return result;
	}//setDelete
}//MemoMybatisDAO
