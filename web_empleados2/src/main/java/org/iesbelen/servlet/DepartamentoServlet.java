package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.dao.DepartamentosDAO;
import org.iesbelen.model.Departamentos;
import org.iesbelen.model.DepartamentosDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "departamentoServlet", value = "/web/departamentos/*")
public class DepartamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {
            DepartamentosDAO deDAO = new DepartamentoDAOImpl();

            String filtro1 = req.getParameter("filtro1");
            String filtro2 = req.getParameter("filtro2");

            List<Departamentos> listaDepartamentos;
            if (filtro1 != null && !filtro1.isEmpty() && filtro2 != null && !filtro2.isEmpty()) {
                int filtro1int = Integer.parseInt(filtro1);
                int filtro2int = Integer.parseInt(filtro2);
                System.out.println(filtro1int);
                System.out.println(filtro2int);
                listaDepartamentos = deDAO.filtroPresupuesto(filtro1int, filtro2int);
            } else {
                listaDepartamentos = deDAO.getAll();
            }

            List<DepartamentosDTO> depDTO = listaDepartamentos.stream()
                    .map(departamentos -> new DepartamentosDTO(departamentos, deDAO.getCountDepartamentos(departamentos.getCodigo()).orElse(0))).toList();
            req.setAttribute("listaDepartamentos", depDTO);

            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos-crear.jsp");
            } else if (pathParts.length == 2) {
                DepartamentosDAO deDAO = new DepartamentoDAOImpl();

                try {
                    req.setAttribute("departamento", deDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/departamentos/detalle-departamento.jsp");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Opcion no soportada");
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");
            }
        }

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        String __method__ = req.getParameter("__method__");
        if (__method__ != null && "crear".equals(__method__)) {

            DepartamentosDAO deDAO = new DepartamentoDAOImpl();

            String nombre = req.getParameter("nombre");
            int presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
            int gastos = Integer.parseInt(req.getParameter("gastos"));

            Departamentos dep = new Departamentos();

            dep.setNombre(nombre);
            dep.setPresupuesto(presupuesto);
            dep.setGastos(gastos);

            deDAO.create(dep);
        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(req, resp);
        } else {
            System.out.println("Opcion no soportada");
        }
        resp.sendRedirect(req.getContextPath() + "/web/departamentos");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        DepartamentosDAO deDAO = new DepartamentoDAOImpl();

        String codigo = req.getParameter("codigo");

        try {
            int id = Integer.parseInt(codigo);
            deDAO.delete(id);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
