package com.company.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.ProductDao;
import com.company.model.ExtProductVo;
import com.company.model.FileVo;
import com.company.model.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

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
	public List<ExtProductVo> selectListByCate(int category) {
		// TODO Auto-generated method stub
		List<ExtProductVo> productVo = productDaoDbg.selectListByCate(category);
		for (ExtProductVo extProductVo : productVo) {
			if (extProductVo.getStoredFileName() == null) {
				extProductVo.setStoredFileName("shirts.jpg");
			}
		}
		return productVo;
	}

	@Override
	public ProductVo selectDetail(int number, String productName) {
		// TODO Auto-generated method stub
		ProductVo productVo = productDaoDbg.selectDetail(number);
		List<Map<Integer, Integer>> sizeAndStock = productDaoDbg.selectStock(productName);
		//int i = 1;
		String comments = "";
		for (Map<Integer, Integer> map : sizeAndStock) {
			if(map.get(1) < 1){
				comments = "(Ç°Àý)";
			}
			productVo.getSizeAndStock().put(map.get(0)+comments, map.get(1));
			comments = "";
			/*
			productVo.getSizeAndStock().put("size" + i, map.get(0));
			productVo.getSizeAndStock().put("stock" + i, map.get(1));
			i++;*/
		}
		return productVo;
	}

	@Override
	public FileVo selectImage(int productNo) {
		FileVo fileVo = null;
		try {
			fileVo = productDaoDbg.selectImage(productNo);
		} catch (Exception e) {
			if (fileVo == null) {
				fileVo = new FileVo();
				fileVo.setStoredFileName("shirts.jpg");
			}
		}

		return fileVo;
	}

	@Override
	public int insertSizeAndStock(int[] size, int[] stock, String productName, int productNo) {
		// TODO Auto-generated method stub
		return productDaoDbg.insertSizeAndStock(size, stock, productName,
				productNo);
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

	@Override
	public int insertImage(FileVo fileVo) {
		// TODO Auto-generated method stub

		return productDaoDbg.insertImage(fileVo);
	}

	@Override
	public int selectNumber(String productName) {
		return productDaoDbg.selectNumber(productName);
	}

}
