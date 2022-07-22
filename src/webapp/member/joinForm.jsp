<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 폼</title>
</head>
<body>
<h2>회원 가입</h2>
<form action="" method="post">
    username:
    <label for="username">
        <input type="text" name="username" id="username">
    </label>
    <br>

    password:
    <label for="password">
        <input type="password" name="password" id="password">
    </label>
    <br>

    name:
    <label for="name">
        <input type="text" name="name" id="name">
    </label>
    <br>

    email:
    <label for="email">
        <input type="email" name="email" id="email">
    </label>
    <br>

    <button type="submit">회원가입</button>
    <button type="button">이전으로</button>

</form>
</body>
</html>