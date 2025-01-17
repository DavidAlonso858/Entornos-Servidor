<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Categoria" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Categoria</title>
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
    <form action="${pageContext.request.contextPath}/web/categoria/">
        <input class="bg-warning text-dark" type="submit" value="Volver"/>
    </form>
</div>
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <form action="${pageContext.request.contextPath}/web/categoria/editar/" method="post">
        <input type="hidden" name="__method__" value="put"/>
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Editar Categoria</h1>
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

        <% Optional<Categoria> optCa = (Optional<Categoria>) request.getAttribute("categoria");
            if (optCa.isPresent()) {
        %>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Código</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="idcat" value="<%= optCa.get().getIdcat() %>" readonly="readonly"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Nombre</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" value="<%= optCa.get().getNombre() %>"/>
            </div>
        </div>

        <% } else { %>

        request.sendRedirect("categoria/");

        <% } %>
    </form>
</div>

</body>
</html>