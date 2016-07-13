package com.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.model.ProductVo;
@Repository
public class ProductDaoDbg implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from DBG_PRODUCT_TB", Integer.class);
	}

	@Override
	public int selectCountCate(int category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from DBG_PRODUCT_TB where category = ?", Integer.class, category);
	}
	
	@Override
	public List<ProductVo> selectListByName(String productName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select no, product_name, brand_name, price from DBG_PRODUCT_TB where product_name = ?", listMapper(), productName);
	}

	@Override
	public List<ProductVo> selectListByCate(int category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select no, product_name, brand_name, price from DBG_PRODUCT_TB where category = ?", listMapper(), category);
	}

	@Override
	public ProductVo selectDetail(int number) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from DBG_PRODUCT_TB where no = ?", productMapper(), number);
	
	}
	
	@Override
	public List<Map<Integer, Integer>> selectStock(String productName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from DBG_PRODUCTSUB_TB where product_name = ?", stockMapper(), productName);
	}
	
	@Override
	public int insert(ProductVo productVo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into DBG_PRODUCT_TB (product_name, category, brand_name, price, material, register_date) values(?, ?, ?, ?, ?, now())",
				productVo.getProductName(), productVo.getCategory(), productVo.getBrandName(), productVo.getPrice(), productVo.getMaterial());
	}

	@Override
	public int update(ProductVo productVo, int number) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update DBG_PRODUCT_TB set product_name = ?, category = ?, brand_name = ?, price = ?, material = ? where no = ?",
				productVo.getProductName(), productVo.getCategory(), productVo.getBrandName(), productVo.getPrice(), productVo.getMaterial(), number);
	}

	@Override
	public int delete(String productName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from DBG_PRODUCT_TB where product_name = ?", productName)
			  +jdbcTemplate.update("delete from DBG_PRODUCTSUB_TB where product_name = ?", productName);

	}
	private RowMapper<ProductVo> listMapper(){
		return new RowMapper<ProductVo>() {
			
			@Override
			public ProductVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ProductVo productVo = new ProductVo();
				productVo.setNumber(rs.getInt("no"));
				productVo.setProductName(rs.getString("product_name"));
				productVo.setBrandName(rs.getString("brand_name"));
				productVo.setPrice(rs.getInt("price"));
				return productVo;
			}
		};
	}
	private RowMapper<ProductVo> productMapper(){
		return new RowMapper<ProductVo>() {
			
			@Override
			public ProductVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ProductVo productVo = new ProductVo();
				productVo.setNumber(rs.getInt("no"));
				productVo.setProductName(rs.getString("product_name"));
				productVo.setCategory(rs.getInt("category"));
				productVo.setBrandName(rs.getString("brand_name"));
				productVo.setPrice(rs.getInt("price"));
				productVo.setMaterial(rs.getString("material"));
				productVo.setRegisterDate(rs.getTimestamp("register_date"));
				return productVo;
			}
		};
	}
	private RowMapper<Map<Integer, Integer>> stockMapper(){
		return new RowMapper<Map<Integer, Integer>>() {
			@Override
			public Map<Integer, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Map<Integer, Integer> stock= new HashMap<>();
				stock.put(0, rs.getInt("size"));
				stock.put(1, rs.getInt("stock"));
				return stock;
			}
		};
	}



}
