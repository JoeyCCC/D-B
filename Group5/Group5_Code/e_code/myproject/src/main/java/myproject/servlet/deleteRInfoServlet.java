package myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.bd.DBConnect;
import myproject.dao.impl.RobotDAOImpl;

public class deleteRInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
        String robotid = request.getParameter("robotid");

        try {
        	RobotDAOImpl dao = new RobotDAOImpl();
        	dao.deleteRobotInfo (robotid);
            response.sendRedirect("ssuccess.jsp");

            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("eerror.jsp");
        }
    }
}
