<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Dashboard</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <style>
    /* CSS styles can be adjusted as needed */
    body {
      background: #f2f2f2;
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    
    .user-profile {
      position: fixed;
      top: 20px;
      right: 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      z-index: 999;
    }
    
    .user-avatar {
      width: 80px;
      height: 80px;
      border-radius: 50%;
      background-color: #ffffff;
      border: 3px solid #ffffff;
      overflow: hidden;
      position: relative;
      cursor: pointer;
    }
    
    .user-avatar img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
    
    .user-options {
      margin-top: 10px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    
    .user-option {
      margin-top: 10px;
      background-color: #ffffff;
      border-radius: 50%;
      width: 40px;
      height: 40px;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
    }
    
    .user-option i {
      color: #333333;
      font-size: 20px;
    }
    
    .user-option-list {
      display: none;
      position: absolute;
      top: 40px;
      right: -10px;
      width: 150px;
      background-color: #ffffff;
      border-radius: 5px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
      z-index: 1000;
    }
    
    .user-option:hover .user-option-list {
      display: block;
    }
    
    .user-option-list-item {
      padding: 10px;
      color: #333333;
      cursor: pointer;
    }
    
    .user-option-list-item:hover {
      background-color: #f2f2f2;
    }

    .username-display {
      margin-top: 20px;
      text-align: center;
    }

    .data-display {
      margin-top: 50px;
      text-align: center;
    }
  </style>
</head>
<body>
  <div class="user-profile">
    <div class="user-avatar">
      <!-- Replace with user avatar image -->
      <img src="user_avatar.png" alt="User Avatar">
    </div>
    <div class="user-options">
      <div class="user-option" onclick="toggleOptionsList()">
        <i class="fas fa-cog"></i>
        <div class="user-option-list" id="user-option-list">
          <button onclick="navigateTo('settings.html')" class="user-option-list-item">Settings</button>
          <button onclick="navigateTo('change_password.html')" class="user-option-list-item">Change Password</button>
          <!-- Add more options as needed -->
        </div>
      </div>
    </div>
    <div class="username-display">
      <!-- Replace with user's username -->
      <h2>Welcome, John Doe!</h2>
    </div>
  </div>

  <div class="data-display">
    <h1>RobotRecord Details</h1>
    <table>
      <tr>
        <th>Robot ID</th>
        <th>State</th>
        <th>Real-time Map</th>
        <th>Pictures</th>
        <th>Average Maze Exploration Time</th>
        <th>Exploration Times</th>
        <th>Statistics of Treasures</th>
      </tr>
      <%-- 使用 JSP 标签获取并显示 robotrecord 数据 --%>
      <%
        try {
          myproject.dao.impl.UserDAOImpldb userDAOImpldb = new myproject.dao.impl.UserDAOImpldb();
          myproject.vo.UserInfodb robotRecord = userDAOImpldb.getRobotRecordByUsername((String) session.getAttribute("username"));
          if (robotRecord != null) {
      %>
      <tr>
        <td><%= robotRecord.getRobotId() %></td>
        <td><%= robotRecord.getState() %></td>
        <td><%= robotRecord.getRealtimeMap() %></td>
        <td><%= robotRecord.getPictures() %></td>
        <td><%= robotRecord.getAverageMazeExplorationTime() %></td>
        <td><%= robotRecord.getExplorationTimes() %></td>
        <td><%= robotRecord.getStatisticsOfTreasures() %></td>
      </tr>
      <%
          } else {
      %>
      <tr>
        <td colspan="7">No robotrecord data found.</td>
      </tr>
      <%
          }
        } catch (Exception e) {
          e.printStackTrace();
      %>
      <tr>
        <td colspan="7">Error occurred while retrieving robotrecord data.</td>
      </tr>
      <%
        }
      %>
    </table>
  </div>

  <script>
    function toggleOptionsList() {
      var optionsList = document.getElementById("user-option-list");
      optionsList.style.display = optionsList.style.display === "block" ? "none" : "block";
    }

    function navigateTo(url) {
      window.location.href = url;
    }

    window.addEventListener("click", function(event) {
      var optionsList = document.getElementById("user-option-list");
      if (event.target.closest(".user-option") === null && event.target !== optionsList) {
        optionsList.style.display = "none";
      }
    });
  </script>
</body>
</html>

