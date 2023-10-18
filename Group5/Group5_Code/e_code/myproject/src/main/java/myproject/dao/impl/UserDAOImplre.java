package myproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.bd.DBConnect;
import myproject.dao.UserDAOre;
import myproject.vo.UserInfosi;

public class UserDAOImplre implements UserDAOre {

    public int queryByUserInfosi(UserInfosi userinfosi) throws Exception {
        int flag = 0;
        String sqlCheck = "SELECT COUNT(*) FROM java WHERE username=?";
        String sqlInsert = "INSERT INTO java (username, password) VALUES (?, ?)";
        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtInsert = null;
        DBConnect dbc = null;
        Connection connection = null;

        if (userinfosi.getUsernamesign() != "" && userinfosi.getPasswordsign() != "") {
            if (userinfosi.getPasswordsign().equals(userinfosi.getPasswordsignre())) {
                try {

                    dbc = new DBConnect();
                    connection = dbc.getConnection();
                    connection.setAutoCommit(false); 

       
                    pstmtCheck = connection.prepareStatement(sqlCheck);
                    pstmtCheck.setString(1, userinfosi.getUsernamesign());
                    ResultSet rs = pstmtCheck.executeQuery();
                    rs.next();
                    int count = rs.getInt(1);
                    rs.close();

                    if (count > 0) {
         
                        flag = 2;
                    } else {
                    
                        pstmtInsert = connection.prepareStatement(sqlInsert);
                        pstmtInsert.setString(1, userinfosi.getUsernamesign());
                        pstmtInsert.setString(2, userinfosi.getPasswordsign());
                        pstmtInsert.executeUpdate();

                        flag = 1;
                    }

                    connection.commit(); 
                } catch (SQLException e) {
                    connection.rollback(); 
                    System.out.println(e.getMessage());
                } finally {
                
                    if (pstmtCheck != null) {
                        pstmtCheck.close();
                    }
                    if (pstmtInsert != null) {
                        pstmtInsert.close();
                    }
                    if (connection != null) {
                        connection.setAutoCommit(true); 
                        connection.close();
                    }
                    if (dbc != null) {
                        dbc.close();
                    }
                }
            } else {
                flag = 4;
            }
        } else {
            flag = 3;
        }

        return flag;
    }
}
