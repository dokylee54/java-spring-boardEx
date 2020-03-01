package com.springbook.view.board;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("board")   // model에 "board"라는 이름으로 저장되는 데이터가 있다면, 그 데이터를 세션(HttpSession)에도 자동으로 저장하라는 설정
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/dataTransform.do")
    @ResponseBody
    public BoardListVO dataTransform(BoardVO vo) {
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardList = boardService.getBoardList(vo);
        BoardListVO boardListVO = new BoardListVO();
        boardListVO.setBoardList(boardList);
        return boardListVO;
    }


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
    public String insertBoard(BoardVO vo) throws IOException {
        System.out.println("글 등록 처리");

        MultipartFile uploadFile = vo.getUploadFile();
        if(!uploadFile.isEmpty()) {
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("/Users/dokylee/Desktop/java_proj/upload-imgs/"+fileName));
        }

        boardService.insertBoard(vo);
//        return "getBoardList.do"; // 포워딩 방식: 브라우저의 URL 변하지 않음 => "/insertBoard.do" 그대로
        return "redirect:getBoardList.do"; // URL => "/getBoardList.do"
    }

    // 글 수정
    @RequestMapping(value = "/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo) {
        // ㄴ> 세션에 board로 저장된 데이터가 있으면 vo에 할당한 후, 사용자가 입력한 파라미터값을 vo 객체에 할당 ==> 그래서 이전정보+새로운정보 모두 가능

        boardService.updateBoard(vo);
        return "getBoardList.do";
    }

    // 글 삭제
    @RequestMapping(value = "/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        boardService.deleteBoard(vo);
        return "getBoardList.do";
    }

    //글 상세 조회
    @RequestMapping(value = "/getBoard.do")
    public String getBoard(BoardVO vo, Model model) {
        model.addAttribute("board", boardService.getBoard(vo));
        return "getBoard.jsp";
    }

    // 글 목록 검색
    @RequestMapping(value = "/getBoardList.do")
//    public String getBoardList(@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
//                               @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//                               BoardVO vo, Model model) {
    public String getBoardList(BoardVO vo, Model model) {

        // Null Check
        if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
        if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

        System.out.println("검색 조건: "+vo.getSearchCondition());
        System.out.println("검색 단어: "+vo.getSearchKeyword());

        // Model 정보 저장
        model.addAttribute("boardList", boardService.getBoardList(vo));
        return "getBoardList.jsp";  // View 이름 리턴
    }
}
