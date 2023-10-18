<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error: Robot ID Already Exists</title>
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

    .error h3 {
      margin-bottom: 20px;
      color: #555;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="error">
      <h2>Failure: The robot ID already exists</h2>
      <h3>Please check the input or delete the existing car record before you try again</h3>
    </div>
  </div>
</body>
</html>
