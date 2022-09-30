package application_baepo.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import application_baepo.config.MybatisManager;
import application_baepo.model.dto.Application_baepoDTO;

public class Application_baepoDAO {
	String tableName = "member";
	
	public List<Application_baepoDTO> getSelectAll() {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", tableName);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		List<Application_baepoDTO> list = session.selectList("application_baepo.getSelectAll", map);
		session.close();
		
		return list;
	}//getSelectAll
	
	public Application_baepoDTO getSelectOne(Application_baepoDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", tableName);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		Application_baepoDTO returnDto = session.selectOne("application_baepo.getSelectOne", map);
		session.close();
		
		return returnDto;
	}//getSelectAll
	
	public int setInsert(Application_baepoDTO paramDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", tableName);
		map.put("dto", paramDto);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("application_baepo.setInsert", map);
		session.commit();
		session.close();
		
		return result;
	}//getSelectAll
}//Application_baepoDAO
