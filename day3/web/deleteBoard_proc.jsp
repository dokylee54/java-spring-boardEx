<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: dokylee
  Date: 28/02/2020
  Time: 3:20 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 1. 사용자 입력 정보 추출
    String seq = request.getParameter("seq");

    // 2. DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(vo);

    // 3. 화면 네비게이션
    response.sendRedirect("getBoardList.jsp");
%>
