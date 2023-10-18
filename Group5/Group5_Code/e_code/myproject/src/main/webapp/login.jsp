<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login and Sign Up Page</title>
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
      height: 100vh;
    }

    .form {
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* 添加立体效果 */
      padding: 20px;
      width: 350px;
      margin: 10px;
      position: relative;
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

    .form input[type="text"],
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

    .overlay {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.9);
      background: linear-gradient(to right, #00aaff, #0066ff);
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      text-align: center;
      visibility: hidden;
    }

    .overlay-text {
      font-size: 30px;
      font-weight: bold;
      color: #333;
      margin-bottom: 20px;
    }

    .l1,
    .l2 {
      font-size: 16px;
      color: #555;
    }

    .form:hover .overlay {
      visibility: hidden;
    }

    .form:not(:hover) .overlay {
      visibility: visible;
    }

    /* Additional Styles */

    .background-image {
      background-image: url("background.jpg");
      background-size: cover;
      background-position: center;
    }

    .form:before {
      content: "";
      position: absolute;
      top: -10px;
      left: -10px;
      right: -10px;
      bottom: -10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      z-index: -1;
    }

    .form-icon {
      position: absolute;
      top: 50%;
      left: 15px;
      transform: translateY(-50%);
      color: #999;
    }

    .form-icon i {
      font-size: 20px;
    }

    .form input[type="text"]:focus,
    .form input[type="password"]:focus {
      border-color: #4caf50;
      box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
    }

    .form-animation {
      animation: formAnimation 1s infinite alternate;
    }

    @keyframes formAnimation {
      0% {
        transform: translateY(0);
      }
      100% {
        transform: translateY(-5px);
      }
    }

    /* Custom Styles */

    .form.login {
      background-color: rgba(255, 255, 255, 0.8);
    }

    .form.signup {
      background-color: rgba(255, 255, 255, 0.9);
    }

    /* Custom Title and Welcome Message */

    .title {
      text-align: center;
      font-size: 36px;
      font-weight: bold;
      color: #fff;
      margin-bottom: 20px;
      text-transform: uppercase;
    }

    .welcome-message {
      text-align: center;
      font-size: 18px;
      color: #fff;
      margin-bottom: 40px;
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
    <div class="header">Welcome to Robot Control System</div>

    <form class="form form-animation login" action="./login" method="post">
      <h2>Login</h2>
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required>

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
      <i class="form-icon fas fa-lock"></i>

      <input type="submit" name="submit" value="Submit">

      <div class="overlay">
        <span class="overlay-text">Login</span>
        <p class="l1">If you already have an account</p>
        <p class="l2">log in!</p>
      </div>
    </form>

    <form class="form form-animation signup" action="./sign" method="post">
      <h2>Sign Up</h2>
      <label for="usernamesign">Username:</label>
      <input type="text" id="usernamesign" name="usernamesign" required>

      <label for="password">Password:</label>
      <input type="password" id="passwordsign" name="passwordsign" required>

      <label for="password">Confirm Password:</label>
      <input type="password" id="passwordsignre" name="passwordsignre" required>
      <i class="form-icon fas fa-user-plus"></i>

      <input type="submit" name="Finish" value="Finish">

      <div class="overlay">
        <span class="overlay-text">Sign Up</span>
        <p class="l1">If you don't have an account</p>
        <p class="l2">log in!</p>
      </div>
    </form>

    <div class="footer">&copy; 2023 Robot Control System. All rights reserved.</div>
  </div>
</body>
</html>


