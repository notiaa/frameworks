<!-- <%@ page import ="java.util.List" %>
<%
    List<String> nom = (List<String>)request.getAttribute("donne");
%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- <%
        for(String s : nom){ %>
            <p><%= s %></p>
        <% }
    %> -->
    
    <%@ page import ="model.Emp" %>
    <%
            Emp emp = (Emp)request.getAttribute("objet");
            String nom = emp.getNom();
    %>

    <h4> <%= nom %> </h4>
    
</body>
</html>
