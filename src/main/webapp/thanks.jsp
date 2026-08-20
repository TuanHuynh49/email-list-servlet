<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>
    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>

    <p><b>Email:</b> ${user.email}</p>
    <p><b>First Name:</b> ${user.firstName}</p>
    <p><b>Last Name:</b> ${user.lastName}</p>

    <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</body>
</html>