<html>
    <head>
        <title>My first webapp</title>
    </head>

    <body>
        <p style="color: red">${error}</p>
        <form method="post" action="/login">
<%--        <form>--%>
            <input type="text" id="name" name="name"/>
            <input type="password" id="password" name="password" />
            <button type="submit">Login</button>
        </form>
    </body>
</html>
