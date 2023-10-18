<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Robot Information</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <style>
    body {
      background: linear-gradient(to right, #3366ff, #66ccff);
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      height: 100vh;
    }

    .form {
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
      padding: 20px;
      width: 350px;
      margin: 10px;
    }

    .form h1 {
      font-size: 24px;
      text-align: center;
      margin-bottom: 20px;
      color: #333;
      text-transform: uppercase;
      letter-spacing: 2px;
    }

    .form label {
      margin-bottom: 5px;
      color: #555;
    }

    .form input[type="text"],
    .form input[type="number"],
    .form input[type="checkbox"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      color: #333;
    }

    .form input[type="submit"] {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 10px;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
      text-transform: uppercase;
      letter-spacing: 1px;
      transition: background-color 0.3s ease;
    }

    .form input[type="submit"]:hover {
      background-color: #45a049;
    }

    /* Additional Styles */

    .header {
      text-align: center;
      font-size: 36px;
      font-weight: bold;
      color: #fff;
      margin-bottom: 20px;
      text-transform: uppercase;
    }

    .footer {
      text-align: center;
      font-size: 18px;
      color: #fff;
      margin-top: 40px;
    }
  </style>
</head>

<body>
  <div class="container background-image">
    <div class="header">Add Robot Information</div>

    <form class="form" method="post" action="./recordAdd">
      <h1>Add Robot Information</h1>

      <label for="robotid">Robot ID:</label>
      <input type="text" id="robotid" name="robotid" required>

      <label for="state">State:</label>
      <input type="checkbox" id="state" name="state">

      <label for="realtimeMap">Real-time Map:</label>
      <input type="text" id="realtimeMap" name="realtimeMap">

      <label for="pictures">Pictures:</label>
      <input type="text" id="pictures" name="pictures">

      <label for="averageMazeExplorationTime">Average Maze Exploration Time:</label>
      <input type="number" id="averageMazeExplorationTime" name="averageMazeExplorationTime" step="0.01" required>

      <label for="explorationTimes">Exploration Times:</label>
      <input type="number" id="explorationTimes" name="explorationTimes" required>

      <label for="statisticsOfTreasures">Statistics of Treasures:</label>
      <input type="number" id="statisticsOfTreasures" name="statisticsOfTreasures" required>

      <input type="submit" value="Submit">
    </form>

    <div class="footer">&copy; 2023 Robot Control System. All rights reserved.</div>
  </div>
</body>
</html>
