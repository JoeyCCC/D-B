package myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.dao.impl.UserDAOupImpl;

public class UserUpdataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

   
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String oldPassword = request.getParameter("current-password");
        String newPassword = request.getParameter("new-password");
        String confirmPassword = request.getParameter("confirm-password");

        UserDAOupImpl userDAOupImpl = new UserDAOupImpl();
        int flag = userDAOupImpl.updatePassword(username, oldPassword, newPassword, confirmPassword);

        if (flag == 1) {
            response.sendRedirect("./success.jsp");
        } else {
  
            response.sendRedirect("./fail.jsp");
        }
    }
}

