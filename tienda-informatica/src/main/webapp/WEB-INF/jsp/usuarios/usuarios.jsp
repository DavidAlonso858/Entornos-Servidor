<%--
  Created by IntelliJ IDEA.
  User: Propietario
  Date: 22/11/2024
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Usuario" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }
    </style>
    <%@include file="/WEB-INF/jsp/fragmentos/estilo.jspf" %>
    <%@include file="/WEB-INF/jsp/fragmentos/boostrap2.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
<main>
    <section>
        <div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
            <div class="clearfix">
                <div style="float: left; width: 50%">
                    <h1>Usuarios</h1>
                </div>
                <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                    <div style="position: absolute; left: 39%; top : 39%;">

                        <form action="${pageContext.request.contextPath}/tienda/usuarios/crear">
                            <input type="submit" value="Crear">
                        </form>
                    </div>

                </div>
            </div>
            <div class="clearfix">
                <hr/>
            </div>
            <div class="clearfix">
                <div style="float: left;width: 10%">idUsuario</div>
                <div style="float: left;width: 30%">Usuario</div>
                <div style="float: left;width: 20%">Password</div>
                <div style="float: left;width: 10%;overflow: hidden;">Rol</div>
                <div style="float: left;width: 10%;overflow: hidden;">Accion</div>
            </div>
            <div class="clearfix">
                <hr/>
            </div>
            <%
                if (request.getAttribute("listaUsuarios") != null) {
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");

                    for (Usuario usu : listaUsuarios) {
            %>

            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 10%"><%= usu.getIdUsuario()%>
                </div>
                <div style="float: left;width: 30%"><%= usu.getUsuario()%>
                </div>
                <div style="float: left;width: 20%"><%= usu.getPassword()%>
                </div>
                <div style="float: left;width: 10%"><%= usu.getRol()%>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <form action="${pageContext.request.contextPath}/tienda/usuarios/<%= usu.getIdUsuario()%>"
                          style="display: inline;">
                        <input type="submit" value="Ver Detalle"/>
                    </form>
                    <form action="${pageContext.request.contextPath}/tienda/usuarios/editar/<%= usu.getIdUsuario()%>"
                          style="display: inline;">
                        <input type="submit" value="Editar"/>
                    </form>
                    <form action="${pageContext.request.contextPath}/tienda/usuarios/borrar/" method="post"
                          style="display: inline; ">
                        <input type="hidden" name="__method__" value="delete"/>
                        <input type="hidden" name="codigo" value="<%= usu.getIdUsuario()%>"/>
                        <input type="submit" value="Eliminar"/>
                    </form>
                </div>
            </div>
            <%
                }
            } else {
            %>
            No hay registros de producto
            <% } %>
        </div>
    </section>
</main>
<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

</body>
</html>
