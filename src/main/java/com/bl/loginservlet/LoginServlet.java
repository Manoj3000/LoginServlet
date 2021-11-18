package com.bl.loginservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value ="Demo" ),
                @WebInitParam(name = "password", value ="Demo@1234" )
        }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        String userNameRegex = "^[A-Z]{1}[a-z]{2,16}";
        String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&_-]{1}).{8,}";

        if(checkValidation(user, userNameRegex) && checkValidation(pass, passwordRegex)){
            String userId = getServletConfig().getInitParameter("user");
            String password = getServletConfig().getInitParameter("password");

            if (userId.equals(user) && password.equals(pass)){
                req.setAttribute("user",user);
                req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
            }else {
                RequestDispatcher rq = getServletContext().getRequestDispatcher("/Login.jsp");
                PrintWriter out = resp.getWriter();
//                out.println("<font color=red>Either username or password is wrong!</font>");
                req.setAttribute("error","Either username or password is wrong!");
                rq.include(req, resp);
            }
        }else {
            RequestDispatcher rq = getServletContext().getRequestDispatcher("/Login.jsp");
            PrintWriter out = resp.getWriter();
//            out.println("<font color=red>Invalid username or password!</font>");
            req.setAttribute("error","Invalid username or password!");
            rq.include(req, resp);
        }
    }

    private boolean checkValidation(String user, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);
        return matcher.find();
    }
}
