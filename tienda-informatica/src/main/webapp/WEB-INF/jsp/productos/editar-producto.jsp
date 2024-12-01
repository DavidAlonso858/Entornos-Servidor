<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 01/12/2024
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Producto</title>
</head>
<body>
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <form action="${pageContext.request.contextPath}/tienda/productos/editar/" method="post">
        <input type="hidden" name="__method__" value="put"/>
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Editar Producto</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Guardar"/>
                </div>

            </div>
        </div>
        <div class="clearfix">
            <hr/>
        </div>

        <% Optional<Producto> proOpt = (Optional<Producto>) request.getAttribute("producto");
            if (proOpt.isPresent()) {
        %>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>idProducto</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="idProducto" value="<%= proOpt.get().getIdProducto() %>" readonly="readonly"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Nombre</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" value="<%= proOpt.get().getNombre() %>"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left; width: 50%">
                <label>Precio</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="precio" value="<%=proOpt.get().getPrecio()%>">
            </div>
        </div>
        <%}%>
    </form>
</div>
</body>
</html>
