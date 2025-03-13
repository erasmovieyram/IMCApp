<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form action="LoginServlet" method="POST">
        <label>Nombre de usuario:</label>
        <input type="text" name="nombre_usuario" required><br>
        <label>Contraseña:</label>
        <input type="password" name="contrasena" required><br>
        <button type="submit">Iniciar Sesión</button>
    </form>
    <p style="color: red;">${error}</p>
</body>
</html>
