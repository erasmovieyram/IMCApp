<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Historial de IMC</title>
</head>
<body>
    <h1>Historial de IMC</h1>
    <table border="1">
        <tr>
            <th>Fecha</th>
            <th>IMC</th>
            <th>Clasificación</th>
        </tr>
        <c:forEach var="medicion" items="${historial}">
            <tr>
                <td>${medicion.fecha}</td>
                <td>${medicion.imc}</td>
                <td>
                    <c:choose>
                        <c:when test="${medicion.imc < 18.5}">Bajo peso</c:when>
                        <c:when test="${medicion.imc < 25}">Peso normal</c:when>
                        <c:when test="${medicion.imc < 30}">Sobrepeso</c:when>
                        <c:otherwise>Obesidad</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="calculo.jsp">Volver al cálculo</a>
</body>
</html>
