package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.DepartamentoDAO;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.model.Departamento;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "departamentoServlet", value = "/web/departamentos/*")
public class DepartamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            DepartamentoDAO deDAO = new DepartamentoDAOImpl();

            //GET
            //	/departamentos/
            //	/departamentos

            List<Departamento> listaDepartamentos = deDAO.getAll();


            request.setAttribute("listaDepartamentos", listaDepartamentos);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");


            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                // /departamentos/crear

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamento-crear.jsp");
            } else {
                System.out.println("Opcion no soportada");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");
            }
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ != null && "crear".equalsIgnoreCase(__method__)) {
            // Crear uno nuevo
            DepartamentoDAO deDAO = new DepartamentoDAOImpl();

            String nombre = request.getParameter("nombre");
            int presupuesto = Integer.parseInt(request.getParameter("presupuesto"));
            int gastos = Integer.parseInt(request.getParameter("gastos"));

            Departamento de = new Departamento();

            de.setNombre(nombre);
            de.setPresupuesto(presupuesto);
            de.setGastos(gastos);

            deDAO.create(de);

        } else {
            System.out.println("Opcion no soportada");
        }
        response.sendRedirect(request.getContextPath() + "/web/departamentos");
    }
}
