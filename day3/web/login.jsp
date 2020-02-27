<%--
  Created by IntelliJ IDEA.
  User: dokylee
  Date: 28/02/2020
  Time: 12:10 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>로그인</title>
</head>
<body>
<center>
  <h1>로그인</h1>
  <hr>

  <form action="login_proc.jsp" method="post">

    <table border="1" cellpadding="0" cellspacing="0">

      <tr>
        <td bgcolor="orange">아이디</td>
        <td><input type="text" name="id"/></td>
      </tr>

      <tr>
        <td bgcolor="orange">비밀번호</td>
        <td><input type="password" name="password"/></td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="로그인" />
        </td>
      </tr>

    </table>

  </form>

</center>
</body>
</html>

