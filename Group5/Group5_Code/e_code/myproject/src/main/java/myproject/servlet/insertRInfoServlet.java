package myproject.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.bd.DBConnect;
import myproject.dao.impl.RobotDAOImpl;

public class insertRInfoServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String robotid = request.getParameter("robotid");
        boolean state = Boolean.parseBoolean(request.getParameter("state"));
        String realtimeMap = request.getParameter("realtimeMap");
        String pictures = request.getParameter("pictures");
        float averageMazeExplorationTime = Float.parseFloat(request.getParameter("averageMazeExplorationTime"));
        int explorationTimes = Integer.parseInt(request.getParameter("explorationTimes"));
        int statisticsOfTreasures = Integer.parseInt(request.getParameter("statisticsOfTreasures"));

        try {

        	RobotDAOImpl dao = new RobotDAOImpl();
        	dao.addRobotInfo (robotid, state, realtimeMap, pictures, averageMazeExplorationTime, explorationTimes, statisticsOfTreasures);

            response.sendRedirect("ssuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();

     
            response.sendRedirect("errorHasId.jsp");
        }
       
    }
    }