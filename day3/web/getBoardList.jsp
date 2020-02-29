<%--
  Created by IntelliJ IDEA.
  User: dokylee
  Date: 28/02/2020
  Time: 12:49 오전
  To change this template use File | Settings | File Templates.
--%>
<%--<%@page import="java.util.List" %>--%>
<%--<%@ page import="com.springbook.biz.board.BoardVO" %>--%>

<%--<%--%>
<%--    // 세션에 저장된 글 목록을 꺼낸다.--%>
<%--    List<BoardVO> boardList = (List) session.getAttribute("boardList");--%>
<%--%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>글 목록</title>
</head>
<body>
<center>
    <h1>글 목록</h1>
    <h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>

    <!--검색 시작-->
    <form action="getBoardList.jsp" method="post">
        <table border="1" cellpadding="0" cellspacing="0" width="700">
            <tr>
                <td align="right">
                    <select name="searchCondition">
                        <option value="TITLE">제목</option>
                        <option value="CONTENT">내용</option>
                    </select>
                    <input name="searchKeyword" type="text" />
                    <input type="submit" value="검색" />
                </td>
            </tr>
        </table>
    </form>
    <!--검색 종료-->

    <table border="1" cellpadding="0" cellspacing="0" width="700">
        <tr>
            <th bgcolor="orange" width="100">번호</th>
            <th bgcolor="orange" width="200">제목</th>
            <th bgcolor="orange" width="150">작성자</th>
            <th bgcolor="orange" width="150">등록일</th>
            <th bgcolor="orange" width="100">조회수</th>
        </tr>

<%--        <% for(BoardVO board : boardList) { %>--%>
<%--        <tr>--%>
<%--            <td><%= board.getSeq() %></td>--%>
<%--            <td align="left">--%>
<%--                <a href="getBoard.do?seq=<%= board.getSeq() %>">--%>
<%--                    <%= board.getTitle() %>--%>
<%--                </a>--%>
<%--            </td>--%>
<%--            <td><%= board.getWriter() %></td>--%>
<%--            <td><%= board.getRegDate() %></td>--%>
<%--            <td><%= board.getCnt() %></td>--%>
<%--        </tr>--%>
<%--        <% } %>--%>

        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.seq}</td>
                <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.regDate}</td>
                <td>${board.cnt}</td>
            </tr>
        </c:forEach>
    </table>

    <br>

    <a href="insertBoard.jsp">새글 등록</a>

</center>
</body>
</html>
