package myproject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.bd.DBConnect;
import myproject.dao.UserDAOup;
import myproject.vo.UserInfo;

public class UserDAOupImpl implements UserDAOup {

    public int updatePassword(String username, String oldPassword, String newPassword, String confirmPassword) {
        int flag = 0; 

     
        UserInfo userinfo = new UserInfo();
        userinfo.setUsername(username);
        userinfo.setPassword(oldPassword);
        try {
            int loginFlag = queryByUserInfoup(userinfo);
            if (loginFlag == 1) {

                if (newPassword.equals(confirmPassword)) {
          
                    String sqlUpdate = "UPDATE java SET password = ? WHERE username = ?";
                    PreparedStatement pstmtUpdate = null;
                    DBConnect dbc = null;
                    try {
                   
                        dbc = new DBConnect();
                        pstmtUpdate = dbc.getConnection().prepareStatement(sqlUpdate);
                        pstmtUpdate.setString(1, newPassword);
                        pstmtUpdate.setString(2, username);

                   
                        int rowsAffected = pstmtUpdate.executeUpdate();
                        if (rowsAffected > 0) {
                       
                            flag = 1;
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                     
                        if (pstmtUpdate != null) {
                            pstmtUpdate.close();
                        }
                        if (dbc != null) {
                            dbc.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public int queryByUserInfoup(UserInfo userinfo) throws Exception {
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