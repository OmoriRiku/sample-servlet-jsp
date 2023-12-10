<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Book, bean.User, java.util.List"%>
<%
  List<Book> list = (List<Book>)request.getAttribute("list");
  User user = (User)session.getAttribute("user");
%>

<%@include file="../header.html" %>

<table>
  <thead>
    <tr>
      <td>ID</td>
      <td>題名</td>
      <td>説明</td>
    </tr>
  </thead>
  <% for(Book book : list) { %>
  <tbody>
  <tr>
    <td><%=book.getId()%></td>
    <td><%=book.getTitle()%></td>
    <td><%=book.getDescription()%></td>
    <td><a href="Find.action?id=<%=book.getId()%>">詳細</a></td>
    <td><a href="update-in.jsp?id=<%=book.getId()%>">編集する</a></td>
    <td><a href="Delete.action?id=<%=book.getId()%>">削除する</a></td>
  </tr>
  <% } %>
  </tbody>
</table>

<hr>
<form action="Add.action" method="post">
  <div>
    <p>本のタイトル:</p>
    <input type="text" name="title">
  </div>
  <div>
    <p>本の説明：</p>
    <textarea name="description" cols="30" rows="5">説明文</textarea>
  </div>
  <input type="hidden" name="user_id" value="<%=user.getId()%>">
  <input type="submit" value="追加する">
</form>


<%@include file="../footer.html" %>