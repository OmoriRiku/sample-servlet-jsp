<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.User" %>
<% User user = (User)session.getAttribute("user"); %>

<%@include file="../header.html" %>

こんにちは、<%=user.getName()%>さん。

<%@include file="../footer.html" %>