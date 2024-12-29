<%@ page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Producto" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 01/12/2024
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Producto</title>
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
            <h1>Detalle Producto</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/comercio/productos/">
                    <input type="submit" value="Volver"/>
                </form>
            </div>

        </div>

    </div>
    <div class="clearfix">
        <hr/>

    </div>
    <%
        Optional<Producto> proOp = (Optional<Producto>) request.getAttribute("producto");
        if (proOp.isPresent()) {
    %>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>idProducto</label>

        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= proOp.get().getIdProducto() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Nombre</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%=proOp.get().getNombre()%>" readonly="readonly">
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float:left; width: 50%">
            <label>Precio</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%=proOp.get().getPrecio()%>" readonly="readonly">
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float:left; width: 50%">
            <label>Descripcion</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%=proOp.get().getDescripcion()%>" readonly="readonly">
        </div>
    </div>
    <%} else {%>
    request.sendRedirect("productos/");
    <%}%>
</div>
</body>
</html>
