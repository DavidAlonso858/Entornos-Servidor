<%--
  Created by IntelliJ IDEA.
  User: Propietario
  Date: 22/11/2024
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Usuario</title>
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
            <h1>Detalle Usuario</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/comercio/usuarios">
                    <input type="submit" value="Volver"/>
                </form>
            </div>

        </div>
    </div>

    <div class="clearfix">
        <hr/>
    </div>

    <% Optional<Usuario> optUsu = (Optional<Usuario>) request.getAttribute("usuario");
        if (optUsu.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>idFabricante</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUsu.get().getIdUsuario() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Usuario</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUsu.get().getUsuario() %>" readonly="readonly"/>
        </div>

    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Password</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUsu.get().getPassword() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Direccion</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUsu.get().getDireccion() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Rol</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUsu.get().getRol() %>" readonly="readonly"/>
        </div>
    </div>

    <% } else { %>

    request.sendRedirect("fabricantes/");

    <% } %>

</div>

</body>
</html>
