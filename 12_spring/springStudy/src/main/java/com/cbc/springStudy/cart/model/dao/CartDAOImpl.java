package com.cbc.springStudy.cart.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cbc.springStudy.cart.model.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CartDTO> getSelectAll() {
		return sqlSession.selectList("cart.getSelectAll");
	}//getSelcetAll

	@Override
	public int setInsert(CartDTO paramDto) {
		return sqlSession.insert("cart.setInsert", paramDto);
	}//setInsert

	@Override
	public int setUpdate(CartDTO paramDto) {
		return sqlSession.update("cart.setUpdate", paramDto);
	}//setUpdate

	@Override
	public int setDelete(CartDTO paramDto) {
		return sqlSession.delete("cart.setDelete", paramDto);
	}//setDelete

	@Override
	public int setClear(CartDTO paramDto) {
		return sqlSession.delete("cart.setClear", paramDto);
	}//setClear
}//CartDAOImpl
