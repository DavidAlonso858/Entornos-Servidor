
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<main>
    <div class="d-grid gap-2 p-5" style="margin: 100px 100px 360px 100px" id="contenedor">
        <a class="btn btn-primary btn-lg" href="<%=application.getContextPath()%>/web/empleados/">EMPLEADOS</a>
        <a class="btn btn-success btn-lg" href="<%=application.getContextPath()%>/web/departamentos">DEPARTAMENTOS</a>
    </div>
</main>
</body>
</html>
</body>
</html>
