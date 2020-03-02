package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object)
@Repository
public class BoardDAOMybatis {
    @Autowired
    private SqlSessionTemplate mybatis;

    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> Mybatis로 insertBoard() 기능 처리");

        mybatis.insert("BoardDAO.insertBoard", vo);
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> Mybatis로 updateBoard() 기능 처리");

        mybatis.update("BoardDAO.updateBoard", vo);
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> Mybatis로 deleteBoard() 기능 처리");

        mybatis.delete("BoardDAO.deleteBoard", vo);
    }

    // 글 상세 조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> Mybatis로 getBoard() 기능 처리");

        return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> Mybatis로 getBoardList() 기능 처리");

        return mybatis.selectList("BoardDAO.getBoardList", vo);
    }

}