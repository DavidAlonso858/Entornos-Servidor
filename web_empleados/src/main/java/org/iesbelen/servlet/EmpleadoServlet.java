package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.EmpleadoDAO;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.model.Empleado;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "empleadoServlet", value = "/web/empleados/*")
public class EmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            EmpleadoDAO emDAO = new EmpleadoDAOImpl();

            //GET
            //	/empleados/
            //	/empleados

            List<Empleado> listaEmpleados = emDAO.getAll();


            request.setAttribute("listaEmpleados", listaEmpleados);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");


            if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                EmpleadoDAO emDAO = new EmpleadoDAOImpl();
                // /empleados/editar{id}
                try {
                    request.setAttribute("empleado", emDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/editar-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleado.jsp");
                }

            } else {
                System.out.println("Opcion no soportada");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");
            }
        }
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String __method__ = request.getParameter("__method__");

        if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(request, response);

        } else {
            System.out.println("Opcion no soportada");
        }

        response.sendRedirect(request.getContextPath() + "/web/empleados");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadoDAO emDAO = new EmpleadoDAOImpl();
        String nif = request.getParameter("nif");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");

        Empleado em = new Empleado();

        try {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
            em.setCodigo(codigo);
            em.setNif(nif);
            em.setNombre(nombre);
            em.setApellido1(apellido1);
            em.setApellido2(apellido2);

            emDAO.update(em);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

}
