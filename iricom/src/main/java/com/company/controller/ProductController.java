package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.ProductVo;
import com.company.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productServiceImpl;
	
	@RequestMapping("/product/list")
	public String productList(@RequestParam(value="cate",required=true, defaultValue="0") int category, Model model){
		
		List<ProductVo> productVoList = productServiceImpl.selectListByCate(category);
		
		model.addAttribute("productVoList", productVoList);
		
		return "/product/list";
	}
	
	@RequestMapping("/product/detail")
	public String product(@RequestParam(value="cate",required=true, defaultValue="0") int category,
			              @RequestParam(value="pno",  required=true) int number,
			              @RequestParam(value="pname", required=true) String productName, Model model) {
		
		ProductVo productVo = productServiceImpl.selectDetail(number, productName);
		
		model.addAttribute("productVo", productVo);
		
		return "/product/detail";
	}
	
	
}
