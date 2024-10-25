<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>FORMULARIO</h1>
<br/>
<form action="formulario" method="post">
    <label for="nombre">Nombre: </label>
    <input type="text" id="nombre" name="nombre">

    <label for="apellido">&emsp;Apellidos: </label>
    <input type="text" id="apellido" name="apellido">

    <label for="edad">Edad: </label>
    <select id="edad" name="edad">
        <option selected value="...">...</option>
        <option value="+18">+18</option>
        <option value="+18">+18</option>
        <option value="-18">-18</option>
        <option value="+30">+30</option>
        <option value="+40">+40</option>
        <option value="+50">+50</option>
    </select>
    <br>
    <label for="peso">Peso: </label>
    <input type="number" name="peso" id="peso">
    <label for=peso>kg &emsp;</label>


    <label for="hombre">Sexo: </label>
    <input type="radio" name="sexo" id="hombre" value="hombre">
    <label for="hombre"> Hombre </label>
    <input type="radio" name="sexo" id="mujer" value="mujer">
    <label for="mujer"> Mujer </label>

    <label for="estado">&emsp;Estado Civil: </label>
    <input type="radio" name="estado" id="estado" value="soltero">
    <label for="hombre"> Soltero </label>
    <input type="radio" name="estado" id="estado2" value="casado">
    <label for="mujer"> Casado </label>
    <input type="radio" name="estado" id="estado3" value="otro">
    <label for="estado3"> Otro </label>

    <br>

    <label for="cine">Aficiones: </label>
    <input type="checkbox" name="aficion1" id="cine">
    <label for="cine"> Cine </label>
    <input type="checkbox" name="aficion2" id="literatura">
    <label for="literatura"> Literatura </label>
    <input type="checkbox" name="aficion3" id="tebeos">
    <label for="tebeos"> Tebeos </label>
    <br>&emsp;&emsp;&emsp;&emsp;
    <input type="checkbox" name="aficion4" id="deporte">
    <label for="deporte">Deporte </label>


    <input type="checkbox" name="aficion5" id="musica">
    <label for="musica"> Musica </label>
    <input type="checkbox" name="aficion6" id="television">
    <label for="television"> Television </label>

    <br>
    <br>
    <br>
    <button type="submit" class="btn btn-primary" id="submitButton">Enviar</button>
    <input type="reset" value="Reset">
</form>
</body>
</html>