package com.cbc.springStudy.cart.service;

import java.util.List;

import com.cbc.springStudy.cart.model.dto.CartDTO;

public interface CartService {
	public List<CartDTO> getSelectAll();
	public int setInsert(CartDTO paramDto);
	public int setUpdate(CartDTO paramDto);
	public int setDelete(CartDTO arguDto);
	public int setClear(CartDTO arguDto);
}//CartService
