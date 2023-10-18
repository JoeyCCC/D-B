package myproject.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import myproject.dao.UserDAO;
import myproject.dao.impl.UserDAOImpl;
import myproject.vo.UserInfo;

public class UserloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserInfo userinfo = new UserInfo();
        userinfo.setUsername(req.getParameter("username"));
        userinfo.setPassword(req.getParameter("password"));
        UserDAO dao = new UserDAOImpl();
        int flag = 0;
        try {
            flag = dao.queryByUserInfo(userinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("username", userinfo.getUsername());
            res.sendRedirect("./userDBServlet");
        } else {
            res.sendRedirect("./error.jsp");
        }
    }
}
