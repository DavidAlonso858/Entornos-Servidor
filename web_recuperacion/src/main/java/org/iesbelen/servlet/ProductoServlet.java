package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Categoria;
import org.iesbelen.model.Producto;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productoServlet", value = "/web/producto/*")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {
            ProductoDAO proDAO = new ProductoDAOImpl();

            List<Producto> listaProductos;

            String filtro1 = req.getParameter("filtro1");
            String filtro2 = req.getParameter("filtro2");
            String filtro3 = req.getParameter("filtroStock");

            if (filtro1 != null && !filtro1.isEmpty() && filtro2 != null && !filtro2.isEmpty()) {
                double filtro1Double = Double.parseDouble(filtro1);
                double filtro2Double = Double.parseDouble(filtro2);
                listaProductos = proDAO.filtroPresupuesto(filtro1Double, filtro2Double);
            } else if (filtro3 != null && !filtro3.isEmpty()) {
                int filtro3Int = Integer.parseInt(filtro3);
                listaProductos = proDAO.busquedaStock(filtro3Int);
            } else {
                listaProductos = proDAO.getAll();
            }


            req.setAttribute("listaProductos", listaProductos);
            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/producto.jsp");
        } else {
            pathInfo = pathInfo.replaceAll("$", "");
            String[] pathsParts = pathInfo.split("/");

            if (pathsParts.length == 2 && "crear".equals(pathsParts[1])) {
                CategoriaDAO catDAO = new CategoriaDAOImpl();
                List<Categoria> listaCategorias = catDAO.getAll();

                req.setAttribute("listaCategorias", listaCategorias);
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/crear-producto.jsp");
            } else {
                System.out.println("Opcion no soportada");
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/producto.jsp");
            }
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String __method__ = req.getParameter("__method__");

        if (__method__ != null && "crear".equalsIgnoreCase(__method__)) {
            ProductoDAO proDAO = new ProductoDAOImpl();
            Producto p = new Producto();

            p.setIdcat(Integer.parseInt(req.getParameter("idcat")));
            p.setNombre(req.getParameter("nombre"));
            p.setPrecio(Double.parseDouble(req.getParameter("precio")));
            p.setStock(Integer.parseInt(req.getParameter("stock")));

            proDAO.create(p);
        } else {
            System.out.println("Opcion no soportada");
        }
        resp.sendRedirect(req.getContextPath() + "/web/producto/");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
