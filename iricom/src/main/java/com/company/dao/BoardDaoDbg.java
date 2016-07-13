package com.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.model.BoardVo;

@Repository
public class BoardDaoDbg implements BoardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardVo> rowMapper(){
		return new RowMapper<BoardVo>() {
			@Override
			public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				BoardVo boardVo = new BoardVo();
				boardVo.setNumber(rs.getInt("no"));
				boardVo.setBoardName(rs.getString("board_name"));
				boardVo.setTitle(rs.getString("title"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setUserId(rs.getString("user_id"));
				boardVo.setPostingDate(rs.getTimestamp("posting_date"));
				boardVo.setReadCount(rs.getInt("read_count"));
				boardVo.setCommentCount(rs.getInt("comment_count"));
				return boardVo;
			}
		};
	}
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from DBG_BOARD_TB", Integer.class);
	}

	@Override
	public int selectCount(String boardName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from DBG_BOARD_TB where board_name = ? ", Integer.class, boardName);
	}

	@Override
	public List<BoardVo> selectList(int firstRow, int endRow) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query("select * from DBG_BOARD_TB order by no desc limit ?, ?", rowMapper(), firstRow-1,endRow-firstRow+1);
	}

	@Override
	public List<BoardVo> selectList(String boardName, int firstRow, int endRow) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from DBG_BOARD_TB where board_name = ? order by no desc limit ?, ?", rowMapper(), boardName,firstRow-1,endRow-firstRow+1);
	}

	@Override
	public int insert(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into DBG_BOARD_TB (board_name, title, content, user_id, posting_date, read_count, comment_count) values(?, ?, ?, ?, now(), 0, 0)"
				, boardVo.getBoardName(), boardVo.getTitle(), boardVo.getContent(), boardVo.getUserId());
	}

	@Override
	public int update(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update DBG_BOARD_TB set title = ?, content = ? where no = ?"
				, boardVo.getTitle(), boardVo.getContent(), boardVo.getNumber() );
	}

	@Override
	public int delete(int boardNumber) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from DBG_BOARD_TB where no = ?", boardNumber);
		
	}

	@Override
	public void increaseReadCount(int boardNumber) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update DBG_BOARD_TB set read_count = read_count + 1 where no = ?", boardNumber);
		
	}

	
}
