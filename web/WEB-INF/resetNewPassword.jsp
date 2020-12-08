<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <form action="reset" method="post">
            <h1>Enter a new password</h1>
            <input type="password" name="password" value=""><br>
            <input type="hidden" name="uuid" value="${uuid}"> 
            <input type="submit" name="submit" value="Submit">
        </form>
        <br>
        ${message}
    </body>
</html>
