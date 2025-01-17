<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

    </style>
</head>
<body>
<div class="m-2">
    <form action="${pageContext.request.contextPath}/web/producto/">
        <input class="bg-warning text-dark"  type="submit" value="Volver"/>
    </form>
</div>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <form action="${pageContext.request.contextPath}/web/producto/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Producto</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div class="m-2" style="position: absolute; left: 39%; top : 39%;">
                    <input type="hidden" name="__method__" value="crear"/>
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                ID Categoria
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <select name="idcat" id="idcat">
                    <% if (request.getAttribute("listaCategorias") != null) {
                        List<Categoria> ca = (List<Categoria>) request.getAttribute("listaCategorias");
                        for (Categoria cat : ca) {

                    %>
                    <option value="<%=cat.getIdcat()%>">
                        <%=cat.getNombre()%>
                    </option>
                    <%
                        }
                    } else {
                    %>
                    No hay registros de categoria
                    <% } %>
                </select>
            </div>
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
                Stock
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="stock"/>
            </div>
        </div>

    </form>
</div>

</body>
</html>