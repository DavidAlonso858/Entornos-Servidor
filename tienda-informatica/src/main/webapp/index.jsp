<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <%@include file="WEB-INF/jsp/fragmentos/estilo.jspf" %>
    <%@include file="WEB-INF/jsp/fragmentos/boostrap2.jspf" %>
</head>
<body>

<%@include file="WEB-INF/jsp/fragmentos/header.jspf" %>
<%@include file="WEB-INF/jsp/fragmentos/nav.jspf" %>
<main>
    <div class="d-grid gap-2 p-5" id="contenedor">
        <a class="btn btn-primary btn-lg" href="<%=application.getContextPath()%>/tienda/fabricantes">FABRICANTES</a>
        <a class="btn btn-success btn-lg" href="<%=application.getContextPath()%>/tienda/productos">PRODUCTOS</a>
    </div>
</main>
<%@include file="WEB-INF/jsp/fragmentos/footer.jspf" %>
<%@include file="boostrap.jspf" %>
</body>
</html>