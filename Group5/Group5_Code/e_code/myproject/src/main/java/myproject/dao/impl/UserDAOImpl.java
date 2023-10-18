package myproject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.bd.DBConnect;
import myproject.dao.UserDAO;
import myproject.vo.UserInfo;

public class UserDAOImpl implements UserDAO {

	public int queryByUserInfo(UserInfo userinfo) throws Exception {
	    int flag = 0;
	    String sql = "SELECT * FROM java WHERE username=?";
	    PreparedStatement pstmt = null;
	    DBConnect dbc = null;

	    try {
	
	        dbc = new DBConnect();
	        pstmt = dbc.getConnection().prepareStatement(sql);
	        pstmt.setString(1, userinfo.getUsername());


	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {

	            if (rs.getString("password").equals(userinfo.getPassword())) {
	                flag = 1;
	            }
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

	    return flag;
	}
	}

