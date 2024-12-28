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
  <%@include file="../../../boostrap.jspf"%>
</head>
<body  class="bg-danger text-white">
<%@include file="../fragmentos/nav.jspf"%>

<div class="bg-dark pb-2">
    <h2 class="head1 display-4 fw-bold text-center text-white">Productos</h2>
</div>
<main>
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

                <div class="row justify-content-center">
                    <div class="col-md-4 mb-2 text-center">
                        <form action="" style="display: inline;">
                            <input class="btn btn-warning text-black fw-bold w-100" type="submit" value="Añadir Carrito">
                        </form>
                        <h4 class="m-1 fst-italic"><%=pro.getPrecio()%>  €</h4>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/editar/<%= pro.getIdProducto() %>" style="display: inline;">
                            <input class="btn btn-info text-white fw-bold w-100" type="submit" value="Editar">
                        </form>
                    </div>
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/">
                            <input class="btn btn-danger text-white fw-bold w-100" type="submit" value="Borrar">
                        </form>
                    </div>
                    <div class="col-md-4 mb-2 text-center">
                        <form action="${pageContext.request.contextPath}/comercio/productos/">
                            <input class="btn btn-success text-white fw-bold w-100" type="submit" value="Ver Detalle">
                        </form>
                    </div>
                </div>
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
