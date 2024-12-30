<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.utilities.Util" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <%@include file="../../../boostrap.jspf"%>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<main class=" m-4">
    <section>
        <div class="container">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h1 class="fw-bold">Usuarios</h1>
                <% Usuario u = (Usuario) session.getAttribute("usuario-logado");
                    String rol = (u != null) ? u.getRol() : " ";
                    if ("administrador".equals(rol)) { %>
                <form action="${pageContext.request.contextPath}/comercio/usuarios/crear">
                    <input type="submit" class="btn btn-primary" value="Crear Usuario">
                </form>
                <% } %>
            </div>

            <!-- Tabla de Usuarios -->
            <div class="table-responsive">
                <table class="table table-striped table-bordered ">
                    <thead>
                    <tr>
                        <th>Código</th>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th>Direccion</th>
                        <th>Rol</th>
                        <% if ("administrador".equals(rol)) { %>
                        <% } %>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (request.getAttribute("listaUsuarios") != null) {
                            List<Usuario> listaUsuario = (List<Usuario>) request.getAttribute("listaUsuarios");
                            for (Usuario usuario : listaUsuario) {
                    %>
                    <tr>
                        <td><%= usuario.getIdUsuario() %></td>
                        <td><%= usuario.getUsuario() %></td>
                        <td><%=Util.hashPassword(usuario.getPassword()).substring(0,4) %></td>
                        <td><%= usuario.getDireccion() %></td>
                        <td>
                            <% if ("administrador".equals(usuario.getRol())) { %>
                            <span class="badge bg-warning">Administrador</span>
                            <% } else {%>
                            <span class="badge bg-primary">Cliente</span>
                            <% } %>
                        </td>
                        <% if ("administrador".equals(rol)) { %>
                        <td class="action-btns">
                            <form action="${pageContext.request.contextPath}/comercio/usuarios/<%= usuario.getIdUsuario() %>" style="display: inline;">
                                <input type="submit" class="btn btn-success btn-sm" value="Ver Detalle" />
                            </form>
                            <form action="${pageContext.request.contextPath}/comercio/usuarios/editar/<%= usuario.getIdUsuario() %>" style="display: inline;">
                                <input type="submit" class="btn btn-info btn-sm text-white" value="Editar" />
                            </form>
                            <form action="${pageContext.request.contextPath}/comercio/usuarios/borrar/" method="post" style="display: inline;">
                                <input type="hidden" name="__method__" value="delete"/>
                                <input type="hidden" name="codigo" value="<%= usuario.getIdUsuario() %>"/>
                                <input type="submit" class="btn btn-danger btn-sm" value="Eliminar" />
                            </form>
                        </td>
                        <% } %>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5" class="no-users">No hay registros de Usuarios.</td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

</body>
</html>