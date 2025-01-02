<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 26/12/2024
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FilmBox-Productos</title>
    <style>
        body {
            padding-bottom: 60px; /* para que el footer no corte al ultimo cuando lo creo */
        }
    </style>
  <%@include file="../../../boostrap.jspf"%>
</head>
<body  class="bg-danger text-white">
<%@include file="../fragmentos/nav.jspf"%>

<div class="bg-dark pb-2">
    <h2 class="head1 display-4 fw-bold text-center text-white">Productos</h2>
</div>
<main>
    <% Usuario u = (Usuario) session.getAttribute("usuario-logado");
        String rol = (u != null) ? u.getRol() : " ";
        if ("administrador".equals(rol)) { %>
    <div class="row justify-content-end m-2">
            <form action="${pageContext.request.contextPath}/comercio/productos/crear">
                <input class="bg-primary text-white" type="submit" value="Crear Producto">
            </form>
        </div>
    <% } %>
    <section>
        <div class="container">
            <% if(request.getAttribute("listaProductos") != null) {
                List<Producto> pr = (List<Producto>) request.getAttribute("listaProductos");
                for (Producto pro : pr) {
            %>
            <div class="border border-5 border-shadow bg-black text-white mx-auto my-4 p-4 rounded w-75">
                <h2 class="fw-bold text-center"><%= pro.getNombre() %></h2>

                <div class="d-flex justify-content-center my-3">
                    <img src="${pageContext.request.contextPath}/assets/<%= pro.getIdProducto() %>.jpg"
                         class="img-fluid border border-info border-5"
                         style="width: 350px; height: 500px; object-fit: cover;">
                </div>

                <p class="m-2 text-center"><%=pro.getDescripcion()%></p>
                <%
                    // Verifica si hay un usuario en la sesión
                    Usuario uss = (Usuario) session.getAttribute("usuario-logado");
                    if (uss != null) {
                %>
                <div class="row justify-content-center">
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/detallepedidos/" method="get" style="display: inline;">
                            <input type="hidden" name="codigo" value="<%= pro.getIdProducto() %>">
                            <input class="btn btn-warning text-black fw-bold w-100" type="submit" value="Añadir Carrito">
                        </form>
                        <h4 class="m-1 fst-italic"><%=pro.getPrecio()%>  €</h4>
                    </div>
                </div>
                <%
                } else {
                %>
                <div class="row justify-content-center">
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/usuarios/login/" method="get" style="display: inline;">
                            <input type="hidden" name="codigo" value="<%= pro.getIdProducto() %>">
                            <input class="btn btn-warning text-black fw-bold w-100" type="submit" value="Añadir Carrito">
                        </form>
                        <h4 class="m-1 fst-italic"><%=pro.getPrecio()%>  €</h4>
                    </div>
                </div>
                <%
                    }
                %>

                <%    if ("administrador".equals(rol)) { %>
                <div class="row justify-content-center">
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/editar/<%= pro.getIdProducto() %>" >
                            <input class="btn btn-info text-white fw-bold w-100" type="submit" value="Editar">
                        </form>
                    </div>
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/borrar">
                            <input type="hidden" name="__method__" value="delete"/>
                            <input type="hidden" name="ID" value="<%= pro.getIdProducto()%>"/>
                            <input class="btn btn-danger text-white fw-bold w-100" type="submit" value="Borrar">
                        </form>
                    </div>
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/<%= pro.getIdProducto() %>">
                            <input class="btn btn-success text-white fw-bold w-100" type="submit" value="Ver Detalle">
                        </form>
                    </div>
                </div>
            <% } %>
            </div>
        <%
            }
        } else {
        %>
        No hay registro de Empleados
        <%
            }%>

    </div>
    </section>
</main>
    <%@include file="../fragmentos/footer.jspf"%>
</body>
</html>
