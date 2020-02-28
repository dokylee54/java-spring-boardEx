package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args) {
        // 1. 스프링 컨테이너 구동
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

        // 2. 스프링 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
        BoardService boardService = (BoardService)container.getBean("boardService");

        // 3. 글 등록 기능 테스트
        BoardVO vo = new BoardVO();
//        vo.setSeq(0);
//        System.out.println(vo.getSeq());
        vo.setTitle("임시 제목2");
        vo.setWriter("이도경");
        vo.setContent("임시 내용2 ... ...");
        boardService.insertBoard(vo);

        // 4. 글 목록 검색 기능 테스트
        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO board : boardList) {
            System.out.println("---> "+board.toString());
        }

        // 5. 스프링 컨테이너 종료
        container.close();
    }
}