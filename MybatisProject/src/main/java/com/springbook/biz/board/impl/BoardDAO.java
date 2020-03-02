package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDAO {
    private SqlSession mybatis;

    public BoardDAO() {
        mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
    }

    public void insertBoard(BoardVO vo) {
        mybatis.insert("BoardDAO.insertBoard", vo);  // 몇 건의 데이터가 처리되었는지를 리턴
        mybatis.commit();
    }

    public void updateBoard(BoardVO vo) {
        mybatis.update("BoardDAO.updateBoard", vo);
        mybatis.commit();
    }

    public void deleteBoard(BoardVO vo) {
        mybatis.delete("BoardDAO.deleteBoard", vo);
        mybatis.commit();
    }

    public BoardVO getBoard(BoardVO vo) {
        return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        return mybatis.selectList("BoardDAO.getBoardList", vo);
    }

}
