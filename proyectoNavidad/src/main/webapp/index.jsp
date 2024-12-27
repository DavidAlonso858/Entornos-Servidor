<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>FilmBox</title>
    <%@include file="boostrap.jspf" %>
    <style>
        .btn:hover {
            box-shadow: 0 8px 15px rgba(255, 0, 200, 0.6); /* Sombra más intensa */
            transform: scale(1.5); /* Aumentar ligeramente el tamaño */
            transition: all 0.3s ease; /* Añadir suavidad */
        }
    </style>
</head>
<body class="bg-cover" style="background-image: url('./assets/fondoTerror.jpg');">
<%@include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<div class="bg-dark pb-2">
    <h1 class="head1 display-4 fw-bold text-center text-white">FilmBox</h1>
<div class="head2  fs-5 fw-bold text-center text-white">Comercio sobre grandes obras del cine
</div>
</div>

<main>
<div class="d-grid justify-content-center gap-2 p-5" style="margin: 100px 100px 360px 100px" >

    <a class="btn btn-warning w-auto btn-lg mb-2 fw-bold" href="<%=application.getContextPath()%>/comercio/categorias"
                                                 >Categoria</a>

   <a class="btn btn-danger btn-lg fw-bold"  href="<%=application.getContextPath()%>/comercio/productos"
                                                 >Productos</a>

    </div>
</main>




    <%@include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</div>
</body>
</html>