<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Book, bean.User" %>
<% 
  Book book = (Book)request.getAttribute("book");
  User user = (User)request.getAttribute("user");
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
  <tbody>
  <tr>
    <td><%=book.getId()%></td>
    <td><%=book.getTitle()%></td>
    <td><%=book.getDescription()%></td>
    <td><%=user.getName()%></td>
    <td><a href="update-in.jsp?id=<%=book.getId()%>">編集する</a></td>
  </tr>
</tbody>
</table>

<p><a href="All.action">一覧を表示する</a></p>

<%@include file="../footer.html" %>