<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="/sample/user/Login.action" method="post">
  <p>ユーザー名:<input type="text" name="name"></p>
  <p>パスワード:<input type="text" name="password"></p>
  <p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html" %>