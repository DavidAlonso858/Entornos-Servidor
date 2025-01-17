package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.model.Categoria;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoriaServlet", value = "/web/categoria/*")
public class CategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {
            CategoriaDAO catDAO = new CategoriaDAOImpl();

            List<Categoria> listaCategorias = catDAO.getAll();

            req.setAttribute("listaCategorias", listaCategorias);
            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/categorias/categoria.jsp");
        } else {
            pathInfo = pathInfo.replaceAll("$", "");
            String[] pathsParts = pathInfo.split("/");

            if (pathsParts.length == 3 && "editar".equals(pathsParts[1])) {
                CategoriaDAO catDAO = new CategoriaDAOImpl();

                req.setAttribute("categoria", catDAO.find(Integer.parseInt(pathsParts[2])));
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/categorias/editar-categoria.jsp");
            } else {
                System.out.println("Opcion no soportada");
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/categorias/categoria.jsp");
            }
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String __method__ = req.getParameter("__method__");

        if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(req, resp);
        } else {
            System.out.println("Opcion no soportada");
        }
        resp.sendRedirect(req.getContextPath() + "/web/categoria/");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDAO catDAO = new CategoriaDAOImpl();
        Categoria categoria = new Categoria();

        Integer idcat = Integer.parseInt(req.getParameter("idcat"));
        String nombre = req.getParameter("nombre");

        try {
            categoria.setNombre(nombre);
            categoria.setIdcat(idcat);

            catDAO.update(categoria);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
