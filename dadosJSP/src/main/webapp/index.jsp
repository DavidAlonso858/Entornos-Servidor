<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Comparator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

    String imagenesDados[] = {
            "1.svg",
            "2.svg",
            "3.svg",
            "4.svg",
            "5.svg",
            "6.svg",
    };

    int tirada = (int) (Math.random() * (8 - 2) + 2); // pilla tanto el 7 como el 2
    List<String> almacenarDado = new LinkedList<String>();

    for (int i = 0; i < tirada; i++) {
        int resultadoDado = (int) (Math.random() * (imagenesDados.length));
        almacenarDado.add(imagenesDados[resultadoDado]);
    }

    String mostrar = "";
    for (String elemento : almacenarDado) {
        mostrar += "<img src=\"imgDados/" + elemento + "\">";
        // toma literalmente la comilla \ y no lo vuelve string
    }

    // comparo Strings usando Comparator
    almacenarDado.sort(new Comparator<String>() {
        public int compare(String dado1, String dado2) {
            // Solo el numero del array (eliminando el ".svg" y convirtiendo a entero)
            int num1 = Integer.parseInt(dado1.replace(".svg", ""));
            int num2 = Integer.parseInt(dado2.replace(".svg", ""));
            return Integer.compare(num1, num2);
        }
    });

    String mostrarOrdenado = "";
    for (String elemento : almacenarDado) {
        mostrarOrdenado += "<img src=\"imgDados/" + elemento + "\">";
        // toma literalmente la comilla \ y no lo vuelve string
    }
%>


<!DOCTYPE html>
<html>
<head>
    <title>JSP - TIRADA DADOS</title>
</head>
<body>
<h1><%= "Ordenar dados" %>
</h1>
<p> Actualice la pagina para mostrar una nueva tirada </p>
<h2>Tirada de <%=tirada%> dados
</h2>

<%=mostrar%>
<br/>

<h2>Tirada ordenada</h2>
<%=mostrarOrdenado%>
<br/>
</body>
</html>