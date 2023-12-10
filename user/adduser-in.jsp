<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="Add.action" method="post">
  <p>ユーザー名:<input type="text" name="name"></p>
  <p>パスワード:<input type="text" name="password"></p>
  <p><input type="submit" value="ユーザー新規登録"></p>
</form>

<%@include file="../footer.html" %>