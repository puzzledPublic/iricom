package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.ExtProductVo;
import com.company.model.FileVo;
import com.company.model.ProductVo;
import com.company.model.UserVo;
import com.company.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productServiceImpl;
	
	@RequestMapping("/product/list")
	public String productList(@RequestParam(value="cate",required=true, defaultValue="0") int category, Authentication auth, Model model){
		
		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal != null && principal instanceof UserVo) {
				UserVo userVo = (UserVo) principal;
				model.addAttribute("userVo", userVo);
			}
		}
		
		List<ExtProductVo> productVoList = productServiceImpl.selectListByCate(category);

		model.addAttribute("productVoList", productVoList);
		
		return "/product/list";
	}
	
	@RequestMapping("/product/detail")
	public String product(@RequestParam(value="cate",required=true, defaultValue="0") int category,
			              @RequestParam(value="pno",  required=true) int number,
			              @RequestParam(value="pname", required=true) String productName, Model model) {
		
		ProductVo productVo = productServiceImpl.selectDetail(number, productName);
		FileVo fileVo = productServiceImpl.selectImage(productVo.getNumber());

		model.addAttribute("productVo", productVo);
		model.addAttribute("fileVo", fileVo);
		
		return "/product/detail";
	}

	
}
