package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.BoardDao;
import com.company.model.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDaoDbg;
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return boardDaoDbg.selectCount();
	}

	@Override
	public int selectCount(String boardName) {
		// TODO Auto-generated method stub
		return boardDaoDbg.selectCount(boardName);
	}

	@Override
	public List<BoardVo> selectList(int firstRow, int endRow) {
		// TODO Auto-generated method stub
		return boardDaoDbg.selectList(firstRow, endRow);
	}

	@Override
	public List<BoardVo> selectList(String boardName, int firstRow, int endRow) {
		// TODO Auto-generated method stub
		return boardDaoDbg.selectList(boardName, firstRow, endRow);
	}

	@Override
	public int insert(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDaoDbg.insert(boardVo);
	}

	@Override
	public int update(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDaoDbg.update(boardVo);
	}

	@Override
	public int delete(int boardNumber) {
		// TODO Auto-generated method stub
		return boardDaoDbg.delete(boardNumber);
	}

	@Override
	public void increaseReadCount(int boardNumber) {
		// TODO Auto-generated method stub
		boardDaoDbg.increaseReadCount(boardNumber);
	}

	
	
}
