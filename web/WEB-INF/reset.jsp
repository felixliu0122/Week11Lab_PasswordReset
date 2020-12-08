<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <form action="reset" method="post">
            <h1>Reset Password</h1>
            <p>Please enter your email address to reset your password.</p>
            <label>Email Address: </label>
            <input type="email" name="email" value=""><br>
            <input type="submit" name="submit" value="Submit"><br>
            ${message}
        </form>
    </body>
</html>
