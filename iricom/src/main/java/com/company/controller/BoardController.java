package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.BoardVo;
import com.company.model.PagingVo;
import com.company.model.UserVo;
import com.company.service.BoardServiceImpl;
import com.company.util.DbgUtil;

@Controller
public class BoardController {

	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	@Autowired
	DbgUtil dbgUtil;
	//게시판 리스트
	@RequestMapping("/list")
	public String boardList(@RequestParam(value="p", required = false, defaultValue="1") Integer requestPage,
							@RequestParam(value="bn", required = false) String boardName, Model model){
		//boardName이 있는지 여부
		if(boardName == null || boardName==""){
			return "redirect:/main";
		}
		//requestPage가 양수인지 여부
		if(requestPage < 0){
			return "redirect:/list?bn="+boardName;
		}
		//boardName 게시판의 게시물 개수
		int totalArticleCount = 0;
		totalArticleCount = boardServiceImpl.selectCount(boardName);
		//페이징 계산
		PagingVo pagingVo = dbgUtil.paging(requestPage, 10, totalArticleCount);
		model.addAttribute("paging", pagingVo);
		//게시물 개수가 0인 경우 
		if(totalArticleCount == 0){
			model.addAttribute("hasItem", false);
			return "board/list";
		}
		List<BoardVo> boardVoList = boardServiceImpl.selectList(boardName, pagingVo.getFirstRow(), pagingVo.getEndRow());
		
		model.addAttribute("boardVoList", boardVoList);
		model.addAttribute("hasItem", true);
	
		return "/board/list";
	}
	//글 작성 Form
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeForm(){
		return "/board/writeForm";
	}
	
	//글 작성
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String boardWrite(@RequestParam(value = "title", required = true) String title,
							 @RequestParam(value = "content", required = true) String content,
							 @RequestParam(value = "bn", required = true) String boardName,
							 Authentication auth){
		
		if(boardName == "" || boardName == null){
			return "redirect:/main";
		}
		
		String userId = dbgUtil.getUserId(auth);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardName(boardName);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setUserId(userId);
		
		int result = boardServiceImpl.insert(boardVo);
		
		return "redirect:/list?bn="+boardName;
	}
	
}
