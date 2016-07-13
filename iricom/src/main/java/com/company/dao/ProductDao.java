package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.model.ProductVo;

public interface ProductDao {

	//상품 총 개수
	public int selectCount();
	//카테고리 별 상품 개수
	public int selectCountCate(int category);
	//상품 이름 별 목록
	public List<ProductVo> selectListByName(String productName);
	//상품 카테고리 별 목록
	public List<ProductVo> selectListByCate(int category);
	//상품 디테일
	public ProductVo selectDetail(int number);
	//상품 재고
	public List<Map<Integer, Integer>> selectStock(String productName);
	//상품 등록
	public int insert(ProductVo productVo);
	//상품 수정
	public int update(ProductVo productVo, int number);
	//상품 삭제
	public int delete(String productName);
	
}
