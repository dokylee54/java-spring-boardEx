<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: dokylee
  Date: 28/02/2020
  Time: 3:16 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 1. 사용자 입력 정보 추출
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String seq = request.getParameter("seq");

    // 2. DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setContent(content);
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.updateBoard(vo);

    // 3. 화면 네비게이션
    response.sendRedirect("getBoardList.jsp");
%>
