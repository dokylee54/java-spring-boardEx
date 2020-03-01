<%--
  Created by IntelliJ IDEA.
  User: dokylee
  Date: 28/02/2020
  Time: 12:10 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title><spring:message code="message.user.login.title" /></title>
</head>
<body>
<center>
  <h1><spring:message code="message.user.login.title" /></h1>
  <a href="login.do?lang=en">
    <spring:message code="message.user.login.language.en" />
  </a>&nbsp;&nbsp;
  <a href="login.do?lang=ko">
    <spring:message code="message.user.login.language.ko" />
  </a>
  <hr>

  <form action="login.do" method="post">

    <table border="1" cellpadding="0" cellspacing="0">

      <tr>
        <td bgcolor="orange"><spring:message code="message.user.login.id" /></td>
        <td><input type="text" name="id" value="${user.id}"/></td>
      </tr>

      <tr>
        <td bgcolor="orange"><spring:message code="message.user.login.password" /></td>
        <td><input type="password" name="password" value="${user.password}"/></td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="<spring:message code="message.user.login.loginBtn" />" />
        </td>
      </tr>

    </table>

  </form>

</center>
</body>
</html>

