<%@page contentType="text/html; charset=UTF-8" %>
<%
  String id = request.getParameter("id");
%>
<%@include file="../header.html" %>

<form action="Update.action" method="post">
  <input type="hidden" name="id" value="<%=id%>">
  <p>本のタイトル:</p><input type="text" name="title">
  <p>本の説明:</p><textarea name="description" cols="30" rows="5">説明文</textarea>
  <p><input type="submit" value="更新"></p>
</form>

<%@include file="../footer.html" %>