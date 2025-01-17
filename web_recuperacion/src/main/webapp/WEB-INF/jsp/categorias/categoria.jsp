<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categorias</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div>
    <div class="m-2">
        <form action="${pageContext.request.contextPath}">
            <input class="bg-warning text-dark" type="submit" value="Volver"/>
        </form>
    </div>
    <h1 class="text-center m-2 text-primary">CATEGORIAS</h1>
</div>
<main>
    </section>
    <div class="container">
        <div class="row fw-bold">
            <div class="col-6 display-6">Codigo</div>
            <div class="col-6 display-6">Nombre</div>
        </div>
        <hr class="text-primary"/>
        <% if (request.getAttribute("listaCategorias") != null) {
            List<Categoria> ca = (List<Categoria>) request.getAttribute("listaCategorias");
            for (Categoria cat : ca) {

        %>
        <div class="row">
            <div class="col-6"><%=cat.getIdcat()%>
            </div>
            <div class="col-6"><%=cat.getNombre()%>
            </div>

            <div class="row my-2">
                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/categoria/editar/<%= cat.getIdcat()%>"
                          style="display: inline;">
                        <input type="submit" value="Editar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/categoria/">
                        <input type="submit" value="Borrar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/categoria/">
                        <input type="submit" value="Ver Detalle"/>
                    </form>
                </div>
            </div>

        </div>
        <hr/>
        <%
            }
        } else {
        %>
        No hay registro de Categoria
        <%
            }%>

    </div>
    </section>
</main>
</body>
</html>
