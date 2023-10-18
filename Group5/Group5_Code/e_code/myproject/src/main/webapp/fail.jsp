<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error: Modification Failed</title>
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

    .error h1 {
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
  </style>
</head>
<body>
  <div class="container">
    <div class="error">
      <h1>Error: Modification Failed</h1>
      <p>An error occurred while trying to modify the record.</p>
      <p>Please check your input and try again.</p>
    </div>
  </div>
</body>
</html>
