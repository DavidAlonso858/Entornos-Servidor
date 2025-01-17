<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.iesbelen.dao.CategoriaDAO" %>
<%@ page import="org.iesbelen.dao.CategoriaDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="m-2">
    <form action="${pageContext.request.contextPath}">
        <input class="bg-warning text-dark" type="submit" value="Volver"/>
    </form>
</div>
<div>
    <h1 class="text-center m-2 text-success">PRODUCTOS</h1>
</div>
<main>
    <div class="row justify-content-start m-1">
        <div class="col-2">
            <form action="${pageContext.request.contextPath}/web/producto/crear">
                <input type="submit" value="Crear"/>
            </form>
        </div>
        <div class="col-4">
            <form action="${pageContext.request.contextPath}/web/producto/">
                <input type="text" name="filtro1" maxlength="10" placeholder=" precio minimo...">
                <input type="text" name="filtro2" maxlength="10" placeholder=" precio maximo...">
                <input type="submit" value="Filtrar">
            </form>
        </div>
        <div class="col-4">
            <form style="margin-left: 290px" action="${pageContext.request.contextPath}/web/producto/">
                <input type="text" name="filtroStock" maxlength="4" placeholder="Stock exacto.">
                <input type="submit" value="Busqueda">
            </form>
        </div>
    </div>

    </section>
    <div class="container">
        <div class="row fw-bold">
            <div class="col-2 display-7">Codigo</div>
            <div class="col-2 display-7">Codigo Categoria</div>
            <div class="col-2 display-7">Nombre</div>
            <div class="col-2 display-7">Precio</div>
            <div class="col-2 display-7">Stock</div>
            <div class="col-2 display-7">Nombre Categoria</div>
        </div>
        <hr class="text-success"/>
        <% if (request.getAttribute("listaProductos") != null) {
            List<Producto> pr = (List<Producto>) request.getAttribute("listaProductos");
            for (Producto pro : pr) {

        %>
        <!--Accedo al nombre directamente usando el id del producto que lleva a Categoria-->
        <%
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
            Optional<Categoria> optCa = categoriaDAO.find(pro.getIdcat());
            if (optCa.isPresent()) {
        %>
        <div class="row">
            <div class="col-2"><%=pro.getIdprod()%>
            </div>
            <div class="col-2"><%=pro.getIdcat()%>
            </div>
            <div class="col-2"><%=pro.getNombre()%>
            </div>
            <div class="col-2"><%=pro.getPrecio()%>
            </div>
            <div class="col-2"><%=pro.getStock()%>
            </div>
            <div class="col-2"><%=optCa.get().getNombre()%>
            </div>


            <div class="row my-2">
                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/producto/">
                        <input type="submit" value="Editar"/>
                    </form>
                </div>

                <div class="col-4 align-content-center">
                    <form action="${pageContext.request.contextPath}/web/producto/">
                        <input type="submit" value="Borrar"/>
                    </form>
                </div>

                <div class="col-4">
                    <form action="${pageContext.request.contextPath}/web/producto/">
                        <input type="submit" value="Ver Detalle"/>
                    </form>
                </div>
            </div>

        </div>
        <hr/>
        <%
                }
            }
        } else {
        %>
        No hay registro de Producto
        <%
            }%>

    </div>
    </section>
</main>
</body>
</html>