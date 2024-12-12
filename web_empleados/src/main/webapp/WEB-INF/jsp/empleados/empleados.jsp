<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Empleado" %><%--
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
    <h1 class="text-center">EMPLEADOS</h1>
</div>
<main>
    </section>
    <div class="container">
        <div class="row">
            <div class="col-2">Codigo</div>
            <div class="col-2">nif</div>
            <div class="col-2">nombre</div>
            <div class="col-2">apellido1</div>
            <div class="col-2">apellido2</div>
            <div class="col-2">codigo_departamento</div>
        </div>
        <hr/>
        <% if (request.getAttribute("listaEmpleados") != null) {
            List<Empleado> em = (List<Empleado>) request.getAttribute("listaEmpleados");
            for (Empleado emp : em) {

        %>
        <div class="row">
            <div class="col-2"><%=emp.getCodigo()%>
            </div>
            <div class="col-2"><%=emp.getNif()%>
            </div>
            <div class="col-2"><%=emp.getNombre()%>
            </div>
            <div class="col-2"><%=emp.getApellido1()%>
            </div>
            <div class="col-2"><%=emp.getApellido2()%>
            </div>
            <div class="col-2"><%=emp.getCodigo_departamento()%>
            </div
            <div class="row">
                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/empleados/editar/<%= emp.getCodigo()%>"
                          style="display: inline;">
                        <input type="submit" value="Editar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/empleados/">
                        <input type="submit" value="Borrar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/empleados/">
                        <input type="submit" value="Ver Detalle"/>
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
</body>
</html>
