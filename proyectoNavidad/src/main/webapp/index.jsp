<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TIENDA-COMERCIO</title>
    <%@include file="boostrap.jspf" %>
</head>
<body>
<h1 class="text-center mt-2">Comercio
</h1>
<br/>
<div class="d-flex justify-content-center">
    <button class="btn btn-warning"><a href="<%=application.getContextPath()%>/comercio/categoria"
                                                 class="text-decoration-none text-dark">Categoria</a>
    </button>
    <button class="btn btn-danger"><a href="<%=application.getContextPath()%>/comercio/productos"
                                                 class="text-decoration-none text-dark">Productos</a>
    </button>
</div>
</body>
</html>