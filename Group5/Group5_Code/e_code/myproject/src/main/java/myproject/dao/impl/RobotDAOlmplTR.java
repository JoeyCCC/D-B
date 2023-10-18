package myproject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.bd.DBConnect;
import myproject.dao.UserDAOtr;
import myproject.vo.UserInfotr;

public class RobotDAOlmplTR implements UserDAOtr {

    public UserInfotr getTreasureAttributes() throws Exception {
        UserInfotr treasureAttributes = null;
        String sql = "SELECT time, book, `cube`, `key` FROM treasure";
        PreparedStatement pstmt = null;
        DBConnect dbc = null;

        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                treasureAttributes = new UserInfotr();
                treasureAttributes.setTime(rs.getString("time"));
                treasureAttributes.setBook(rs.getString("book"));
                treasureAttributes.setCube(rs.getString("cube"));
                treasureAttributes.setKey(rs.getString("key"));
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

        return treasureAttributes;
    }
}
