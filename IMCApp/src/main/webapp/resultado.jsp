<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado del IMC</title>
</head>
<body>
    <h1>Resultado del IMC</h1>
    <p>Tu IMC es: ${imc}</p>
    <p>
        <%
            double imc = Double.parseDouble(request.getAttribute("imc").toString());
            if (imc < 18.5) {
                out.println("Clasificación: Bajo peso");
            } else if (imc < 25) {
                out.println("Clasificación: Peso normal");
            } else if (imc < 30) {
                out.println("Clasificación: Sobrepeso");
            } else {
                out.println("Clasificación: Obesidad");
            }
        %>
    </p>
    <a href="calculo.jsp">Calcular nuevamente</a><br>
    <a href="historial.jsp">Ver historial</a>
</body>
</html>
