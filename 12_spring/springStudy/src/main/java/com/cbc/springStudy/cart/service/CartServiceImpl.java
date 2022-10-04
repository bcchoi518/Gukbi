package com.cbc.springStudy.cart.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.springStudy.cart.model.dao.CartDAO;
import com.cbc.springStudy.cart.model.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public List<CartDTO> getSelectAll() {
		return cartDao.getSelectAll();
	}//getSelcetAll

	@Override
	public int setInsert(CartDTO paramDto) {
		return cartDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(CartDTO paramDto) {
		return cartDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setDelete(CartDTO paramDto) {
		return cartDao.setDelete(paramDto);
	}//setDelete

	@Override
	public int setClear(CartDTO paramDto) {
		return cartDao.setClear(paramDto);
	}//setClear

}//CartServiceImpl
