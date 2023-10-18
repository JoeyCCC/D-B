<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Change Password</title>
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

    .form h2 {
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

    .form input[type="password"] {
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
    <div class="header">Change Password</div>

    <form class="form change-password" action="./change-password" method="post">
      <h2>Change Password</h2>

      <label for="current-password">Current Password:</label>
      <input type="password" id="current-password" name="current-password" required>

      <label for="new-password">New Password:</label>
      <input type="password" id="new-password" name="new-password" required>

      <label for="confirm-password">Confirm Password:</label>
      <input type="password" id="confirm-password" name="confirm-password" required>

      <input type="submit" name="submit" value="Submit">
    </form>

    <div class="footer">&copy; 2023 Robot Control System. All rights reserved.</div>
  </div>
</body>
</html>
