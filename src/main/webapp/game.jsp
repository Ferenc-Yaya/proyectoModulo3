<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<!DOCTYPE html>
<html>
<head>
    <title>Galactic Rush - Juego</title>
</head>
<body>
    <h1>Bienvenido al Juego</h1>
    <c:if test="${not empty nombre}">
        <p>Hola, <c:out value="${nombre}" />!</p>
    </c:if>
    <h2><c:out value="${pregunta}" /></h2>

    <c:if test="${empty resultado}">
        <form action="GameServlet" method="post">
            <c:forEach var="option" items="${opciones}">
                <label>
                    <input type="radio" name="respuesta" value="<c:out value='${option}' />" />
                    <c:out value="${option}" />
                </label><br />
            </c:forEach>
            <input type="submit" value="Enviar Respuesta" />
        </form>
    </c:if>

    <c:if test="${not empty resultado}">
        <h2><c:out value="${resultado}" /></h2>
        <form action="GameServlet" method="post">
            <input type="hidden" name="restart" value="true" />
            <input type="submit" value="Reiniciar Juego" />
        </form>
    </c:if>
</body>
</html>

