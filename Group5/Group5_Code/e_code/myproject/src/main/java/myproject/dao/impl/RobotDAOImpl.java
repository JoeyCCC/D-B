package myproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.dao.RobotDAO;
import myproject.bd.DBConnect;
import myproject.vo.UserInfo;

public class RobotDAOImpl implements RobotDAO {

	@Override
	
	

	public void deleteRobotInfo (String robotid) throws Exception{
		
    	DBConnect dbc = null;
		Connection conn = null;
		
		dbc = new DBConnect();
        conn = dbc.getConnection();
        
        String sql = "DELETE FROM RobotRecord WHERE robotid = ?";

  
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, robotid);

 
        pst.executeUpdate();

  
        pst.close();
        conn.close();
        
		}
	

	public void addRobotInfo (String robotid, Boolean state, String realtimeMap, String pictures, Float averageMazeExplorationTime, int explorationTimes, int statisticsOfTreasures) throws Exception{
    	DBConnect dbc = null;
		Connection conn = null;
		
		dbc = new DBConnect();
        conn = dbc.getConnection();


        String sql = "INSERT INTO RobotRecord (robotid, state, realtimeMap, pictures, averageMazeExplorationTime, ExplorationTimes, statisticsOfTreasures) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, robotid);
        pst.setBoolean(2, state);
        pst.setString(3, realtimeMap);
        pst.setString(4, pictures);
        pst.setFloat(5, averageMazeExplorationTime);
        pst.setInt(6, explorationTimes);
        pst.setInt(7, statisticsOfTreasures);
      


        pst.executeUpdate();

  
        pst.close();
        conn.close();
	}
		
	}

	
	
	
	