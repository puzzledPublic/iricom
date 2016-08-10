package com.company.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.model.FileVo;
import com.company.model.ProductVo;
import com.company.service.ProductService;
import com.company.util.DbgUtil;

@Controller
public class AdminController {
	
	@Autowired
	DbgUtil dbgUtil;
	@Autowired
	ProductService productServiceImpl;
	
	@RequestMapping(value="/admin/upload", method=RequestMethod.GET)
	public String productUploadForm(){
		return "/admin/upload";
	}
	//상품 정보 업로드 
	@RequestMapping(value="/admin/upload", method=RequestMethod.POST)
	public String productUpload(@RequestParam(value="productName", required=true) String productName,
								@RequestParam(value="brandName", required=true) String brandName,
								@RequestParam(value="category", required=true) int category,
								@RequestParam(value="price", required=true) int price,
								@RequestParam(value="material", required=true) String material,
								@RequestParam(value="size") int[] size,
								@RequestParam(value="stock") int[] stock,
								@RequestParam(value="image") MultipartFile uploadFile){
		
		//System.out.println(productName +" "+brandName+" "+category+" "+price+" "+material+" "+size[0]+" "+size[1]+" "+size[2]+" "+stock[0]+" "+stock[1]+" "+stock[2]);
		
		//상품 정보
		ProductVo productVo = new ProductVo();
		productVo.setProductName(productName);
		productVo.setBrandName(brandName);
		productVo.setCategory(category);
		productVo.setPrice(price);
		productVo.setMaterial(material);
		
		productServiceImpl.insert(productVo);
		
		//상품 넘버 필요
		int productNo = productServiceImpl.selectNumber(productName);
		
		//상품 사이즈 재고
		productServiceImpl.insertSizeAndStock(size, stock, productName, productNo);
		
		//상품 이미지
		String filePath = "C:\\Users\\KHM\\git\\iricom\\iricom\\src\\main\\webapp\\resources\\image\\";
		File file;
		FileVo fileVo;
		
		if(uploadFile.isEmpty() == false){
			try {
				fileVo = dbgUtil.parseUploadFileInfo(uploadFile);
				fileVo.setProductNo(productNo);
				//파일 생성
				file = new File(filePath+ fileVo.getStoredFileName());
				//파일 저장
				uploadFile.transferTo(file);
				
				//db에 fileInfo 저장 productDao,service 구현필요
				productServiceImpl.insertImage(fileVo);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/main";
	}
}
