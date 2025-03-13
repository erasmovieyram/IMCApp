<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
</head>
<body>
    <h1>Registro de Usuario</h1>
    <form action="RegistroUsuarioServlet" method="POST">
        <label>Nombre completo:</label>
        <input type="text" name="nombre_completo" required><br>
        <label>Edad:</label>
        <input type="number" name="edad" required><br>
        <label>Sexo:</label>
        <select name="sexo">
            <option value="Masculino">Masculino</option>
            <option value="Femenino">Femenino</option>
        </select><br>
        <label>Estatura (m):</label>
        <input type="number" step="0.01" name="estatura" required><br>
        <label>Peso (kg):</label>
        <input type="number" step="0.01" name="peso" required><br>
        <label>Nombre de usuario:</label>
        <input type="text" name="nombre_usuario" required><br>
        <label>Contraseña:</label>
        <input type="password" name="contrasena" required><br>
        <button type="submit">Registrar</button>
    </form>
    <p style="color: red;">${error}</p>
</body>
</html>
