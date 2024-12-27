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

        <%
            if(request.getAttribute("listaProductos") != null) {
            List<Producto> pr = (List<Producto>) request.getAttribute("listaProductos");
            for (Producto pro : pr) {

        %>
<div class="border border-shadow mb-4">

    <h4><%=pro.getNombre()%>
    <img src="${pageContext.request.contextPath}/assets/<%= pro.getIdProducto()%>.jpg" style="width: 200px; height:200px;">
    </h4>

    <div class="col-4">
                    <form action="${pageContext.request.contextPath}/comercio/productos/editar/<%= pro.getIdProducto()%>"
                          style="display: inline;">
                        <input  class="text-white bg-info" type="submit" value="Editar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/comercio/productos/">
                        <input class="text-white bg-info" type="submit" value="Borrar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/comercio/productos/">
                        <input class="text-white bg-info" type="submit" value="Ver Detalle"/>
                    </form>
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
