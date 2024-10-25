<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String nombres[] =
            {
                    "ballena",
                    "caballito-mar",
                    "camello",
                    "cebra",
                    "elefante",
                    "hipopotamo",
                    "jirafa",
                    "leon",
                    "leopardo",
                    "medusa",
                    "mono",
                    "oso",
                    "oso-blanco",
                    "pajaro",
                    "pinguino",
                    "rinoceronte",
                    "serpiente",
                    "tigre",
                    "tortuga",
                    "tortuga-marina"
            };

    String fotos[];

    fotos = new String[]{
            "ballena.svg",
            "caballito-mar.svg",
            "camello.svg",
            "cebra.svg",
            "elefante.svg",
            "hipopotamo.svg",
            "jirafa.svg",
            "leon.svg",
            "leopardo.svg",
            "medusa.svg",
            "mono.svg",
            "oso.svg",
            "oso-blanco.svg",
            "pajaro.svg",
            "pinguino.svg",
            "rinoceronte.svg",
            "serpiente.svg",
            "tigre.svg",
            "tortuga.svg",
            "tortuga-marina.svg"
    };
    int random = (int) (Math.random() * (fotos.length));
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Random Animal</title>
</head>
<body>
<h1><%= "RANDOM ANIMAL" %>
</h1>
<br/>
</body>
<h3><%= nombres[random] %>
</h3>
<img src="imgAnimales/<%= fotos[random]%>">
</html>