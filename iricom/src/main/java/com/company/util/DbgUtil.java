package com.company.util;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.company.model.FileVo;
import com.company.model.PagingVo;
import com.company.model.UserVo;
@Component
public class DbgUtil {

	//requestPage : 요청페이지숫자
	//numberPerPage : 한 페이지에 게시글 개수
	//totalArticleCount : 게시글 총 개수
	public PagingVo paging(int requestPage, int numberPerPage, int totalArticleCount){
		
		final int PAGING_PAGE = 10;
		int totalPageCount = 0;
		int firstRow = 0;
		int endRow = 0;
		int beginPage = 0;
		int endPage = 0;
		
		if(totalArticleCount != 0 || requestPage < 0){
			//게시글 총 개수를 페이지당 게시글 개수로 나눠 총 페이지 개수를 구함
			totalPageCount = totalArticleCount / numberPerPage;
			//소수로 될 경우 +1
			if(totalArticleCount > totalPageCount * numberPerPage){
				totalPageCount++;
			}
			//게시글 첫번째 행 : (요청페이지 - 1) * 페이지 당 게시글 개수 + 1
			firstRow = (requestPage - 1) * numberPerPage + 1;
			//게시글 마지막 행 : 첫번째 행 + 페이지 당 게시글 개수 - 1
			endRow = firstRow + numberPerPage - 1;
			//만약 마지막 행이 전체 게시글 개수 보다 크면 마지막 행에 게시글 개수로 넣는다
			if(endRow > totalArticleCount){
				endRow = totalArticleCount;
			}
			//화면 리스트에 보여줄 페이지 번호
			if(totalPageCount != 0){
				beginPage = (requestPage - 1) / PAGING_PAGE * PAGING_PAGE + 1;
				endPage = beginPage + PAGING_PAGE - 1;
				if(endPage > totalPageCount){
					endPage = totalPageCount;
				}
			}
		}
		else{
			requestPage = 0;
		}
		
		PagingVo pagingVo = new PagingVo(requestPage, totalPageCount, firstRow, endRow, beginPage, endPage);
		return pagingVo;
		
	}
	
	public String getUserId(Authentication auth){
		
		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal != null && principal instanceof UserVo) {
				UserVo userVo = (UserVo) principal;
				
				return userVo.getUserId();
			}
		}
		return "none";
	}
	
	public FileVo parseUploadFileInfo(MultipartFile multipartFile) throws Exception{
		
		String originName;
		String storedName;
		String originExtension;
		FileVo fileVo = new FileVo();
		
		if(!multipartFile.isEmpty() && multipartFile.getContentType().contains("image")){
			originName = multipartFile.getOriginalFilename();
			originExtension = originName.substring(originName.lastIndexOf("."));
			storedName = getRandomString()+originExtension;
			
			fileVo.setOriginFileName(originName);
			fileVo.setStoredFileName(storedName);
			fileVo.setFileSize(multipartFile.getSize());
			
		}
		
		return fileVo;
	}
	
	private String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
