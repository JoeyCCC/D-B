<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error Page</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <style>
    body {
      background-color: #f2f2f2;
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

    .error {
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      padding: 20px;
      width: 350px;
      margin: 10px;
      position: relative;
      text-align: center;
    }

    .error h2 {
      font-size: 24px;
      text-align: center;
      margin-bottom: 20px;
      color: #333;
      text-transform: uppercase;
      letter-spacing: 2px;
    }

    .error p {
      margin-bottom: 20px;
      color: #555;
    }

    .error i {
      font-size: 60px;
      color: #e53935;
    }

    .error span {
      font-size: 18px;
      color: #333;
    }

    .error span.highlight {
      color: #e53935;
      font-weight: bold;
    }
  </style>
    <meta http-equiv="refresh" content="3;url=login.jsp">
</head>
<body>
  <div class="container">
    <div class="error">
      <i class="fas fa-exclamation-triangle"></i>
      <h2>Error</h2>
      <p>The name and password cannot be empty.</p>
      <p>Please provide both a name and a password.</p>
      <p>You will be redirected to the login page in 3 seconds.</p>
      <span>Or click <a href="login.jsp" class="highlight">here</a> to go back immediately.</span>
    </div>
  </div>
</body>
</html>
    