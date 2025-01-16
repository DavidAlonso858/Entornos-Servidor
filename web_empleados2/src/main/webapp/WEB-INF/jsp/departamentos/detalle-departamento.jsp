<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 16/01/2025
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Empleados" %>
<%@ page import="org.iesbelen.model.Departamentos" %>
<%@ page import="org.iesbelen.model.DepartamentosDTO" %>
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
            <h1>Detalle Departamento</h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/web/departamentos/">
        <input type="submit" value="Volver"/>
    </form>

    <div class="clearfix">
        <hr/>
    </div>

    <% Optional<Departamentos> optDe = (Optional<Departamentos>) request.getAttribute("departamento");
        if (optDe.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Codigo</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="codigo" value="<%= optDe.get().getCodigo() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Nombre</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="nombre" value="<%= optDe.get().getNombre() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Presupuesto</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="presupuesto" value="<%= optDe.get().getPresupuesto() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Gastos</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="gastos" value="<%= optDe.get().getGastos() %>" readonly="readonly"/>
        </div>
    </div>



    <% } else { %>

    request.sendRedirect("departamentos/");

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
