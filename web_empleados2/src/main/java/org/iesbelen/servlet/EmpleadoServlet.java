package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.dao.EmpleadosDAO;
import org.iesbelen.model.Empleados;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "empleadoServlet", value = "/web/empleados/*")
public class EmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //
        System.out.println(pathInfo);
        if (pathInfo == null || "/".equals(pathInfo)) {
            EmpleadosDAO emDAO = new EmpleadoDAOImpl();

            //GET
            //	/empleados/
            //	/empleados

            List<Empleados> listaEmpleados = emDAO.getAll();


            request.setAttribute("listaEmpleados", listaEmpleados);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");


            if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                EmpleadosDAO emDAO = new EmpleadoDAOImpl();
                // /empleados/editar{id}
                try {
                    request.setAttribute("empleado", emDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/editar-empleados.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleado.jsp");
                }

            } else if (pathParts.length == 2) {
                EmpleadosDAO emDAO = new EmpleadoDAOImpl();

                try {
                    request.setAttribute("empleado", emDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/detalle-empleado.jsp");

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String __method__ = req.getParameter("__method__");

        if (__method__ != null || "put".equals(__method__)) {
            doPut(req, resp);
        } else {
            System.out.println("Opcion no soportada");
        }

        resp.sendRedirect(req.getContextPath() + "/web/empleados/");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmpleadosDAO empDAO = new EmpleadoDAOImpl();
        String nif = req.getParameter("nif");
        String nombre = req.getParameter("nombre");
        String apellido1 = req.getParameter("apellido1");
        String apellido2 = req.getParameter("apellido2");

        Empleados em = new Empleados();

        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            em.setCodigo(codigo);
            em.setNif(nif);
            em.setNombre(nombre);
            em.setApellido1(apellido1);
            em.setApellido2(apellido2);

            empDAO.update(em);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        EmpleadosDAO empDAO = new EmpleadoDAOImpl();
        String codigo = req.getParameter("codigo");

        try {
            empDAO.delete(Integer.parseInt(codigo));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


