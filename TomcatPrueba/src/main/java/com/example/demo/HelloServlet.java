package com.example.demo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "hello", value = "/nombre-server")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello User! ";
    }

    // ponemos doPost por que el formulario usamos post
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String apellido = request.getParameter("apellidoUsuario");
        String dni = request.getParameter("dniUsuario");

        message = "<h1>" + message + request.getParameter("nombreUsuario") + " " + apellido + " con DNI " + dni + "</h1>";

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(message);
        out.println("</body></html>");
    }


    public void destroy() {
    }
}