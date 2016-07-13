package com.company.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.ProductDao;
import com.company.model.ProductVo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDaoDbg;
	
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return productDaoDbg.selectCount();
	}

	@Override
	public int selectCountCate(int category) {
		// TODO Auto-generated method stub
		return productDaoDbg.selectCountCate(category);
	}

	@Override
	public List<ProductVo> selectListByName(String productName) {
		// TODO Auto-generated method stub
		return productDaoDbg.selectListByName(productName);
	}

	@Override
	public List<ProductVo> selectListByCate(int category) {
		// TODO Auto-generated method stub
		return productDaoDbg.selectListByCate(category);
	}

	@Override
	public ProductVo selectDetail(int number, String productName) {
		// TODO Auto-generated method stub
		ProductVo productVo = productDaoDbg.selectDetail(number);
		List<Map<Integer, Integer>> sizeAndStock = productDaoDbg.selectStock(productName);
		int i = 1;
		for(Map<Integer, Integer> map : sizeAndStock){
			productVo.getSizeAndStock().put("size"+i, map.get(0));
			productVo.getSizeAndStock().put("stock"+i, map.get(1));
			i++;
		}
		
		return productVo;
	}

	@Override
	public int insert(ProductVo productVo) {
		// TODO Auto-generated method stub
		return productDaoDbg.insert(productVo);
	}

	@Override
	public int update(ProductVo productVo, int number) {
		// TODO Auto-generated method stub
		return productDaoDbg.update(productVo, number);
	}

	@Override
	public int delete(String productName) {
		// TODO Auto-generated method stub
		return productDaoDbg.delete(productName);
	}

	
	
}
