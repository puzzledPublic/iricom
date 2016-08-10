package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.model.ExtProductVo;
import com.company.model.FileVo;
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
	public List<ExtProductVo> selectListByCate(int category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select a.no, a.product_name, a.brand_name, a.price, b.stored_file_name from DBG_PRODUCT_TB as a "
				+ "left join DBG_PRODUCTIMG_TB as b on a.no=b.product_no where category = ?", extListMapper(), category);
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
	public int insertSizeAndStock(int[] size, int[] stock, String productName, int productNo) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i = 0 ; i < size.length ; i++){
			result +=jdbcTemplate.update("insert into DBG_PRODUCTSUB_TB (product_name, size, stock, product_no) values(?, ?, ?, ?)",productName , size[i], stock[i], productNo);
		}
		
		return result;
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
	
	@Override
	public int insertImage(FileVo fileVo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into DBG_PRODUCTIMG_TB (origin_file_name, stored_file_name, file_size, upload_date, product_no) values(?, ?, ?, now(), ?)",
				fileVo.getOriginFileName(), fileVo.getStoredFileName(), fileVo.getFileSize(), fileVo.getProductNo());
	}
	@Override
	public FileVo selectImage(int productNo){
		return jdbcTemplate.queryForObject("select * from DBG_PRODUCTIMG_TB where product_no = ?", fileMapper() , productNo);
	}
	@Override
	public int selectNumber(String productName){
		return jdbcTemplate.queryForObject("select no from DBG_PRODUCT_TB where product_name = ?", Integer.class, productName);
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
	private RowMapper<ExtProductVo> extListMapper(){
		return new RowMapper<ExtProductVo>() {
			
			@Override
			public ExtProductVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ExtProductVo productVo = new ExtProductVo();
				productVo.setNumber(rs.getInt("no"));
				productVo.setProductName(rs.getString("product_name"));
				productVo.setBrandName(rs.getString("brand_name"));
				productVo.setPrice(rs.getInt("price"));
				productVo.setStoredFileName(rs.getString("stored_file_name"));
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
	private RowMapper<FileVo> fileMapper(){
		return new RowMapper<FileVo>(){
			@Override
			public FileVo mapRow(ResultSet rs, int rowNum) throws SQLException{
				FileVo fileVo = new FileVo();
				fileVo.setNumber(rs.getInt("no"));
				fileVo.setOriginFileName(rs.getString("origin_file_name"));
				fileVo.setStoredFileName(rs.getString("stored_file_name"));
				fileVo.setProductNo(rs.getInt("product_no"));
				return fileVo;
			}
		};
	}





}
