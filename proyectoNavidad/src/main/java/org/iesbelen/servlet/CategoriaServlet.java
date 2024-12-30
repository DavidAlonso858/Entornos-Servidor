package org.iesbelen.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.model.Categoria;
import org.iesbelen.model.Producto;

@WebServlet(name = "categoria", value = "/comercio/categorias/*")
public class CategoriaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * /categoria/
     * /categoria/{id}
     * /categoria/editar{id}
     * /categoria/crear
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            List<Producto> listaProducto;


            String idCategoria = request.getParameter("idCategoria");

            if (idCategoria != null && !idCategoria.isEmpty()) {
                int categoriaId = Integer.parseInt(idCategoria);
                listaProducto = categoriaDAO.findByCategoria(categoriaId);
            } else {
                listaProducto = null;
            }

            request.setAttribute("listaProductos", listaProducto);

            List<Categoria> listaCategorias = categoriaDAO.getAll();
            request.setAttribute("listaCategorias", listaCategorias);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categorias.jsp");
            dispatcher.forward(request, response);

        } else {
            // GET
            // 		/categoria/edit/{id}
            // 		/categoria/edit/{id}/
            // 		/categoria/crear
            // 		/categoria/crear/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                // GET
                // /fabricantes/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/crear-categoria.jsp");

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                CategoriaDAO catDAO = new CategoriaDAOImpl();

                // GET
                // /categoria/editar/{id}
                try {
                    request.setAttribute("categoria", catDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/editar-categoria.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categorias.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categorias.jsp");

            }
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {
            // Crear uno nuevo
            CategoriaDAO catDAO = new CategoriaDAOImpl();

            String nombre = request.getParameter("nombre");
            Categoria nuevoCat = new Categoria();
            nuevoCat.setNombre(nombre);
            catDAO.create(nuevoCat);

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            // Borrar uno existente
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
            doDelete(request, response);
        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/comercio/categorias");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDAO catDAO = new CategoriaDAOImpl();
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        Categoria cat = new Categoria();

        try {
            int id = Integer.parseInt(codigo);
            cat.setIdCategoria(id);
            cat.setNombre(nombre);
            catDAO.update(cat);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        CategoriaDAO catDAO = new CategoriaDAOImpl();
        String codigo = request.getParameter("codigo");

        try {
            int id = Integer.parseInt(codigo);

            catDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

}
