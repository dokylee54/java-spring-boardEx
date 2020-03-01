package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("board")   // model에 "board"라는 이름으로 저장되는 데이터가 있다면, 그 데이터를 세션(HttpSession)에도 자동으로 저장하라는 설정
public class BoardController {

    // 검색 조건 목록 설정
    @ModelAttribute("conditionMap")
    public Map<String, String> searchConditionMap() {
        Map<String, String> conditionMap = new HashMap<String, String>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }

    // 글 등록
    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 등록 처리");

        boardDAO.insertBoard(vo);
//        return "getBoardList.do"; // 포워딩 방식: 브라우저의 URL 변하지 않음 => "/insertBoard.do" 그대로
        return "redirect:getBoardList.do"; // URL => "/getBoardList.do"
    }

    // 글 수정
    @RequestMapping(value = "/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
        // 세션에 board로 저장된 데이터가 있으면 vo에 할당한 후, 사용자가 입력한 파라미터값을 vo 객체에 할당 ==> 그래서 이전정보+새로운정보 모두 가능
        System.out.println("번호 : "+vo.getSeq());
        System.out.println("제목 : "+vo.getTitle());
        System.out.println("작성자 : "+vo.getWriter());
        System.out.println("내용 : "+vo.getContent());
        System.out.println("등록일 : "+vo.getRegDate());
        System.out.println("조회수 : "+vo.getCnt());

        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }

    // 글 삭제
    @RequestMapping(value = "/deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }

    //글 상세 조회
    @RequestMapping(value = "/getBoard.do")
    public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
        model.addAttribute("board", boardDAO.getBoard(vo));
        return "getBoard.jsp";
    }

    // 글 목록 검색
    @RequestMapping(value = "/getBoardList.do")
    public String getBoardList(@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
                               @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
                               BoardVO vo, BoardDAO boardDAO, Model model) {
        System.out.println("검색 조건: "+condition);
        System.out.println("검색 단어: "+keyword);

        model.addAttribute("boardList", boardDAO.getBoardList(vo));
        return "getBoardList.jsp";
    }
}
