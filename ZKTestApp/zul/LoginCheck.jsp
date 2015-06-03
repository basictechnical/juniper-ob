<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	    
    
        <%
      	String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        if((username.equals("siva") && password.equals("prasad")))
            {
            session.setAttribute("username",username);
            response.sendRedirect("/ZKTestApp/zul/dbconnect.zul");
            }
        else
            response.sendRedirect("login.html");
        %>
    
    </body>
</html>