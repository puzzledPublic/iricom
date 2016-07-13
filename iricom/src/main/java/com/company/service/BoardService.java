package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.model.BoardVo;

public interface BoardService {

	//전체 게시판 게시글 갯수 조회
		public int selectCount();
		//board_name게시판 게시글 갯수 조회
		public int selectCount(String boardName);
		//전체 게시판 리스트 조회
		public List<BoardVo> selectList(int firstRow, int endRow);
		//board_name게시판 리스트 조회
		public List<BoardVo> selectList(String boardName, int firstRow, int endRow);
		//게시글 작성
		public int insert(BoardVo boardVo);
		//게시글 수정
		public int update(BoardVo boardVo);
		//게시글 삭제
		public int delete(int boardNumber);
		//조회수 증가
		public void increaseReadCount(int boardNumber);
	
}
