package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.model.ExtProductVo;
import com.company.model.FileVo;
import com.company.model.ProductVo;

public interface ProductDao {

	//상품 총 개수
	public int selectCount();
	//카테고리 별 상품 개수
	public int selectCountCate(int category);
	//상품 이름 별 목록
	public List<ProductVo> selectListByName(String productName);
	//상품 카테고리 별 목록
	public List<ExtProductVo> selectListByCate(int category);
	//상품 디테일
	public ProductVo selectDetail(int number);
	//상품 재고
	public List<Map<Integer, Integer>> selectStock(String productName);
	//상품 사이즈, 재고 등록
	public int insertSizeAndStock(int[] size, int[] stock, String productName, int productNo);
	//상품 등록
	public int insert(ProductVo productVo);
	//상품 수정
	public int update(ProductVo productVo, int number);
	//상품 삭제
	public int delete(String productName);
	//상품 이미지 등록
	public int insertImage(FileVo fileVo);
	//상품 이미지 가져오기
	public FileVo selectImage(int productNo);
	//no 가져오기
	public int selectNumber(String productName);
}
