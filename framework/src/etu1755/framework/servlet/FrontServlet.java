package etu1755.framework.servlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import etu1755.annotation.Url;
import etu1755.framework.Mapping;
import etu1755.framework.ModelView;
import utils.PackageTool;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class FrontServlet extends HttpServlet{
    HashMap<String,Mapping> urlMapping = new HashMap<>();

    @Override
    public void init() throws ServletException {
        try {
            for (Class c : PackageTool.inPackage(getServletConfig().getInitParameter("model"))){
                for (Method m : c.getDeclaredMethods()){
                    if(m.isAnnotationPresent(Url.class)){
                        urlMapping.put(m.getAnnotation(Url.class).url(), new Mapping(c.getName(), m.getAnnotation(Url.class).url().split("-")[1]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String url = req.getRequestURI();
        url = url.split("/")[url.split("/").length - 1];
        out.println(url);
        if(urlMapping.containsKey(url)){
            try {
                Object act = Class.forName(urlMapping.get(url).getClassName()).newInstance();
                ModelView mv = (ModelView)act.getClass().getDeclaredMethod(urlMapping.get(url).getMethod()).invoke(act);
                for(String cle:mv.getData().keySet()){
                    Object valeur=mv.getData().get(cle);
                    req.setAttribute(cle, valeur);
                }
                ArrayList<String> array = new ArrayList<>();
                Field[] attribut = act.getClass().getDeclaredFields();
                Method[] methods = act.getClass().getDeclaredMethods();
                ArrayList<String> don = new ArrayList<>();
                Enumeration<String> nom = req.getParameterNames();
                while (nom.hasMoreElements()) {
                    array.add(nom.nextElement());
                }
                for (Field i : attribut) {
                    don.add(i.getName());
                }
                for (String string : array) {
                    if (don.contains(string)) {
                        for (Method method : methods) {
                            String setters = "set"+string;
                            if (method.getName().equalsIgnoreCase(setters)) {
                                method.invoke(act, req.getParameter(string));
                            }
                        }
                    }
                }

                req.setAttribute("objet", act);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(mv.getView()) ;    
                requestDispatcher.forward(req,res);
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }
}
