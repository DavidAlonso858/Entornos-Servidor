<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Empleado" %>
<%@ page import="org.iesbelen.model.Departamento" %><%--
  Created by IntelliJ IDEA.
  User: Propietario
  Date: 05/12/2024
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div>
    <h1 class="text-center">DEPARTAMENTOS</h1>
    <form action="${pageContext.request.contextPath}/web/departamentos/crear" clas="m-2">
        <input type="submit" value="Crear">
    </form>
</div>
<main>
    </section>
    <div class="container">
        <div class="row">
            <div class="col-3">Codigo</div>
            <div class="col-3">nombre</div>
            <div class="col-3">presupuesto</div>
            <div class="col-3">gastos</div>
        </div>
        <hr/>
        <% if (request.getAttribute("listaDepartamentos") != null) {
            List<Departamento> de = (List<Departamento>) request.getAttribute("listaDepartamentos");
            for (Departamento dep : de) {

        %>
        <div class="row">
            <div class="col-3"><%=dep.getCodigo()%>
            </div>
            <div class="col-3"><%=dep.getNombre()%>
            </div>
            <div class="col-3"><%=dep.getPresupuesto()%>
            </div>
            <div class="col-3"><%=dep.getGastos()%>
            </div>

            <div class="row">
                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/departamentos/"
                          style="display: inline;">
                        <input type="submit" value="Editar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/departamentos/">
                        <input type="submit" value="Borrar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/departamentos/">
                        <input type="submit" value="Ver Detalle"/>
                    </form>
                </div>
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
</body>
</html>
