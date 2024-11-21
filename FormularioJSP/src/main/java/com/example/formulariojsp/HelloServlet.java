package com.example.formulariojsp;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formulario", value = "/formulario")
public class HelloServlet extends HttpServlet {
    private String message;
    private String nombre;
    private String apellido;
    private String edad;
    private String sexo;
    private String peso;
    private String estado;
    private List<String> aficiones = new LinkedList<>();

    public void init() {
        message = "Informacion Formulario";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        edad = request.getParameter("edad");
        sexo = request.getParameter("sexo");
        peso = request.getParameter("peso");
        estado = request.getParameter("estado");

        if (request.getParameter("aficion1") != null) {
            aficiones.add("Cine");
        }
        if (request.getParameter("aficion2") != null) {
            aficiones.add("Literatura");
        }
        if (request.getParameter("aficion3") != null) {
            aficiones.add("Tebeos");
        }
        if (request.getParameter("aficion3") != null) {
            aficiones.add("Deporte");
        }
        if (request.getParameter("aficion4") != null) {
            aficiones.add("Musica");
        }
        if (request.getParameter("aficion5") != null) {
            aficiones.add("Television");
        }
        if (request.getParameter("aficion6") != null) {
            aficiones.add("Cine");
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "<h1>");
        out.println("<h1>" + "Nombre: " + nombre + "</h1>");
        out.println("<h2>" + "Apellidos: " + apellido + "</h2>");
        out.println("<h3>" + "Edad: " + edad + "</h3>");
        out.println("<h4>" + "Peso: " + peso + "</h4>");
        out.println("<h5>" + "Sexo: " + sexo + "</h5>");
        out.println("<h6>" + "Estado: " + estado + "</h6>");
        out.println("<p>" + "Aficiones: " + aficiones.toString() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}