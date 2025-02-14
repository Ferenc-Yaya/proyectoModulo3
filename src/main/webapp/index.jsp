<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<!DOCTYPE html>
<html>
<head>
    <title>Galactic Rush - Introducción</title>
</head>
<body>
    <h1>Introducción</h1>
    <p>El juego está ambientado en un futuro lejano: el año 3018, en una época en la que los humanos comparten la Tierra con robots y los viajes espaciales son una rutina.</p>

    <h2>Conozca a la tripulación</h2>
    <p><strong>John Squirrels:</strong> Capitán del Galactic Rush</p>
    <p><strong>Eleanor Carrey:</strong> Puedes llamarme Ellie. Soy el navegante aquí en Galactic Rush.</p>

    <h3>Ingrese su nombre:</h3>
    <form action="GameServlet" method="post">
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre" required>
        <input type="submit" value="Iniciar juego">
    </form>
</body>
</html>
