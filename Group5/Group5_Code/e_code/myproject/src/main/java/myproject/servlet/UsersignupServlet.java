
package myproject.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import myproject.dao.UserDAOre;
import myproject.dao .impl.*;

import myproject.vo.UserInfosi;


public class UsersignupServlet extends HttpServlet {
	
	public void doGet (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	UserInfosi userinfosi = new UserInfosi();
	userinfosi.setUsernamesign (req.getParameter("usernamesign"));
	userinfosi.setPasswordsign(req.getParameter("passwordsign"));
	userinfosi.setPasswordsignre(req.getParameter("passwordsignre"));
	UserDAOre dao = new UserDAOImplre();
	int flag = 0;
	try
	{
		flag = dao.queryByUserInfosi (userinfosi);
		}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	if(flag==1)
	{
		HttpSession session=req.getSession();
		session.setAttribute("usernamesign", userinfosi.getUsernamesign());
		res .sendRedirect("./welcome1.jsp");
	}
	if(flag==2)
	{
		res.sendRedirect("./error2.jsp");
	}
	if(flag==3)
	{
		res.sendRedirect("./error3.jsp");
	}
	if(flag==4)
	{
		res.sendRedirect("./error4.jsp");
	}
	}
}
