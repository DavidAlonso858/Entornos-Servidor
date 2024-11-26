<%--
  Created by IntelliJ IDEA.
  User: Propietario
  Date: 26/11/2024
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
    <%@include file="../../../WEB-INF/jsp/fragmentos/boostrap2.jspf" %>
</head>
<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Iniciar Sesion</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/tienda/usuarios">
                    <input type="submit" value="Volver"/>
                </form>
            </div>

        </div>
    </div>

    <hr>
    <form action="${pageContext.request.contextPath}/tienda/usuarios/login" method="get">
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Usuario
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="usuario"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Password
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="password"/>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button class="button bg-primary text-white mt-5" type="submit" name="inicioSesion">Iniciar
            </button>
        </div>
    </form>
</div>
</body>
</html>
