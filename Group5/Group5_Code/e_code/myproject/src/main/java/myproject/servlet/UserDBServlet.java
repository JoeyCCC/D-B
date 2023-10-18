package myproject.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import myproject.dao.UserDAOdb;
import myproject.dao.impl.UserDAOImpldb;
import myproject.vo.UserInfo;
import myproject.vo.UserInfodb;

public class UserDBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        // Pass the username to UserDAOdb for processing
        UserDAOdb dao = new UserDAOImpldb();
        UserInfodb robotRecord = null;
        try {
            robotRecord = dao.getRobotRecordByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (robotRecord != null) {
            session.setAttribute("robotRecord", robotRecord);
            request.getRequestDispatcher("first.jsp").forward(request, response);  
        } else {
            response.sendRedirect("./error.jsp");
        }
        if (username != null) {
            session.setAttribute("username", username);
            response.sendRedirect("./userUpServlet");
        } else {
            response.sendRedirect("./error.jsp");
        }
    }
 }                           

