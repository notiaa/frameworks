<%@ page import="java.util.ArrayList"%>
<%@ page import="etu1755.framework.FileUpload"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test</title>
</head>
<body>
    <h1>Vomay tonga!!!!!</h1>
    <%
    if(request.getAttribute("uploads") != null){%>
        <p><%out.println((ArrayList<FileUpload>)request.getAttribute("uploads"));%></p>
    <%}
    %>
</body>
</html>