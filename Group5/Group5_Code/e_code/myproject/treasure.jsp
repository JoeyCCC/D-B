<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 省略其他头部信息 -->

    <!-- Add your stylesheets and scripts here -->

    <style>
        <!-- 省略原本的CSS样式 -->

        .data-display table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .data-display th, .data-display td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .data-display th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <!-- 省略用户信息的显示部分 -->

    <div class="data-display">
        <h1>Treasure Attributes Details</h1>
        <table>
            <tr>
                <th>Time</th>
                <th>Book</th>
                <th>Cube</th>
                <th>Key</th>
            </tr>
            <%
                try {
                    myproject.dao.impl.RobotDAOlmplTR robotDAOImplTR = new myproject.dao.impl.RobotDAOlmplTR();
                    myproject.vo.UserInfotr treasureAttributes = robotDAOImplTR.getTreasureAttributes();
                    if (treasureAttributes != null && treasureAttributes.getTime() != null
                            && treasureAttributes.getBook() != null && treasureAttributes.getCube() != null
                            && treasureAttributes.getKey() != null) {
            %>
            <tr>
                <td><%= treasureAttributes.getTime() %></td>
                <td><%= treasureAttributes.getBook() %></td>
                <td><%= treasureAttributes.getCube() %></td>
                <td><%= treasureAttributes.getKey() %></td>
            </tr>
            <%
                    } else {
            %>
            <tr>
                <td colspan="4">No treasure attributes data found.</td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
            %>
            <tr>
                <td colspan="4">Error occurred while retrieving treasure attributes data.</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

    <!-- 省略其他部分 -->
</body>
</html>
