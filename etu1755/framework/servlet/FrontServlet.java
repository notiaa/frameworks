package etu1755.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet{

protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    response.setContentType("essaie/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {      
        String url = request.getRequestURL().toString()+"?"+request.getQueryString();
        out.println(url);
    }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    processRequest(request, response);
}


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
}
