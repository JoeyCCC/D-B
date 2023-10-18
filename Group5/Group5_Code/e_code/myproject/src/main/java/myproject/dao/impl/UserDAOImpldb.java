package myproject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.bd.DBConnect;
import myproject.dao.UserDAO;
import myproject.dao.UserDAOdb;
import myproject.vo.UserInfo;
import myproject.vo.UserInfodb;

public class UserDAOImpldb implements UserDAOdb {

    public UserInfodb getRobotRecordByUsername(String username) throws Exception {
    	UserInfodb robotRecord = null;
        String sql = "SELECT * FROM java j JOIN RobotRecord r ON j.robotid = r.robotid WHERE j.username=?";
        PreparedStatement pstmt = null;
        DBConnect dbc = null;

        try {

            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);

  
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
       
                robotRecord = new UserInfodb();
                robotRecord.setRobotId(rs.getString("robotid"));
                robotRecord.setState(rs.getBoolean("state"));
                robotRecord.setRealtimeMap(rs.getString("realtimeMap"));
                robotRecord.setPictures(rs.getString("pictures"));
                robotRecord.setAverageMazeExplorationTime(rs.getFloat("averageMazeExplorationTime"));
                robotRecord.setExplorationTimes(rs.getInt("ExplorationTimes"));
                robotRecord.setStatisticsOfTreasures(rs.getInt("statisticsOfTreasures"));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (dbc != null) {
                dbc.close();
            }
        }

        return robotRecord;
    }
}
