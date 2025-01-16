<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 16/01/2025
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Empleados" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

        Ver Detalle
    </title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

    </style>
</head>
<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Detalle Empleado</h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/web/empleados/">
        <input type="submit" value="Volver"/>
    </form>

    <div class="clearfix">
        <hr/>
    </div>

    <% Optional<Empleados> optEm = (Optional<Empleados>) request.getAttribute("empleado");
        if (optEm.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Código</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="codigo" value="<%= optEm.get().getCodigo() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>nif</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="nif" value="<%= optEm.get().getNif() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Nombre</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="nombre" value="<%= optEm.get().getNombre() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Apellido1</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="apellido1" value="<%= optEm.get().getApellido1() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Apellido2</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="apellido2" value="<%= optEm.get().getApellido2() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Codigo Departamento</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="codigo_departamento" value="<%= optEm.get().getCodigoDepartamento() %>" readonly="readonly"/>
        </div>
    </div>

    <% } else { %>

    request.sendRedirect("empleados/");

    <% } %>
    </form>
</div>

</body>
</html>
</title>
</head>
<body>

</body>
</html>
