<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="org.iesbelen.model.Categoria" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Productos</title>
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
    <form action="${pageContext.request.contextPath}/comercio/productos/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Producto</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Precio
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="precio"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Descripcion
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="descripcion"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Categoria
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <select name="idCategoria">
                <%
                    if (request.getAttribute("listaCategoria") != null) {
                        List<Categoria> listaCategoria = (List<Categoria>) request.getAttribute("listaCategoria");

                        for (Categoria cat : listaCategoria) {
                %>
                <option value="<%=cat.getIdCategoria()%>">
                    <%=cat.getNombre() %>
                </option>
                <%
                    }
                } else {
                %>
                No hay registros de fabricante
                <% } %>
                </select>
            </div>
        </div>


    </form>
</div>

</body>
</html>