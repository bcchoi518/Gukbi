package chart.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import shopMall.model.dao.CartDAO;
import shopMall.model.dto.CartDTO;

public class ChartService {
	
	//db에서 자료를 읽어서 JSON형식으로 리턴하는 코드..
	public JSONObject getChartData() {
		CartDAO cartDao = new CartDAO();
		ArrayList<CartDTO> list = cartDao.getSelectCartProductGroup();
		//리턴할 JSON 객체
		JSONObject data = new JSONObject();
		//컬럼구성..
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		
		col1.put("label", "상품명"); //key, value
		col1.put("type", "string");
		col2.put("label", "금액"); //컬럼이름
		col2.put("type", "number"); //컬럼자료형
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title); //컬럼에 객체 추가...
		
		JSONArray body = new JSONArray();
		for (CartDTO cartDto : list) {
			JSONObject name = new JSONObject();
			name.put("v", cartDto.getProductName());
			
			JSONObject money = new JSONObject();
			money.put("v", cartDto.getBuyMoney());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row); // 셀 추가
			body.add(cell); //row(레코드) 1개 추가
		}//for
		data.put("rows", body);
		return data;
	}//getChartData
}//ChartService