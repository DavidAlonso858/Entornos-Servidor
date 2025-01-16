<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Departamentos" %>
<%@ page import="org.iesbelen.model.DepartamentosDTO" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 14/01/2025
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div>
    <h1 class="text-center">DEPARTAMENTOS</h1>
</div>
<main>
    <div class="row">
        <div class="col-6">
            <form action="${pageContext.request.contextPath}/web/departamentos/crear">
                <input type="submit" value="Crear"/>
            </form>
        </div>
        <div class="col-6">
            <form style="margin-right: 35px" action="${pageContext.request.contextPath}/web/departamentos/">
                <input type="text" name="filtro1" maxlength="10" placeholder="minimo...">
                <input type="text" name="filtro2" maxlength="10" placeholder="maximo...">
                <input type="submit" value="Filtrar">
            </form>
        </div>
        <div>
            <div class="container">
                <div class="row">
                    <div class="col-2">Codigo</div>
                    <div class="col-2">nombre</div>
                    <div class="col-2">presupuesto</div>
                    <div class="col-2">gastos</div>
                    <div class="col-2">empleados</div>
                </div>
                <hr/>

                <%
                    if (request.getAttribute("listaDepartamentos") != null) {
                        List<DepartamentosDTO> de = (List<DepartamentosDTO>) request.getAttribute("listaDepartamentos");
                        for (DepartamentosDTO dep : de) {
                %>

                <div class="row">
                    <div class="col-2"><%=dep.getCodigo()%>
                    </div>

                    <div class="col-2"><%=dep.getNombre()%>
                    </div>

                    <div class="col-2"><%=dep.getPresupuesto()%>
                    </div>

                    <div class="col-2"><%=dep.getGastos()%>
                    </div>
                    <div class="col-2"><%=dep.getConteo()%>
                    </div>


                    <div class="row">
                        <div class="col-4">
                            <form action="${pageContext.request.contextPath}/web/departamentos/">
                                <input type="submit" value="Editar"/>
                            </form>
                        </div>
                        <div class="col-4">
                            <form action="${pageContext.request.contextPath}/web/departamentos/" method="post">
                                <input type="hidden" name="__method__" value="delete"/>
                                <input type="hidden" name="codigo" value="<%=dep.getCodigo()%>"/>
                                <input type="submit" value="Borrar"/>
                            </form>
                        </div>
                        <div class="col-4">
                            <form action="${pageContext.request.contextPath}/web/departamentos/<%=dep.getCodigo()%>">
                                <input type="submit" value="Ver Detalle"/>
                            </form>
                        </div>
                    </div>
                </div>

                <%
                    }
                } else {
                %>
                No hay registros
                <%}%>
            </div>


</main>

</body>

</html>
