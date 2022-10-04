package com.cbc.springStudy.cart.model.dao;

import java.util.List;

import com.cbc.springStudy.cart.model.dto.CartDTO;

public interface CartDAO {
	public List<CartDTO> getSelectAll();
	public int setInsert(CartDTO paramDto);
	public int setUpdate(CartDTO paramDto);
	public int setDelete(CartDTO paramDto);
	public int setClear(CartDTO paramDto);
}//CartDAO
