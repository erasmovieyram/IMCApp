<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cálculo de IMC</title>
</head>
<body>
    <h1>Cálculo de IMC</h1>
    <form action="CalcularIMCServlet" method="POST">
        <label>Masa corporal (kg):</label>
        <input type="number" step="0.01" name="masa" required><br>
        <button type="submit">Calcular IMC</button>
    </form>
    <p style="color: red;">${error}</p>
</body>
</html>
