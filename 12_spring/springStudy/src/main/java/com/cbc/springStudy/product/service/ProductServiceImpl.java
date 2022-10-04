package com.cbc.springStudy.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cbc.springStudy.product.model.dao.ProductDAO;
import com.cbc.springStudy.product.model.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO productDao;
	
	@Override
	public List<ProductDTO> getSelectAll() {
		return productDao.getSelectAll();
	}//getSelectAll

	@Override
	public ProductDTO getSelectOne(ProductDTO paramDto) {
		return productDao.getSelectOne(paramDto);
	}//getSelectOne

	@Override
	public int setInsert(ProductDTO paramDto) {
		return productDao.setInsert(paramDto);
	}//setInsert

	@Override
	public int setUpdate(ProductDTO paramDto) {
		return productDao.setUpdate(paramDto);
	}//setUpdate

	@Override
	public int setDelete(ProductDTO paramDto) {
		return productDao.setDelete(paramDto);
	}//setDelete
}//ProductServiceImpl
