package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Producto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "productoServlet", value = "/comercio/productos/*")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * /productos/
     * /productos/{id}
     * /productos/editar{id}
     * /productos/crear
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String path = req.getPathInfo();

        if (path == null || "/".equals(path)) {
            ProductoDAO proDAO = new ProductoDAOImpl();

            // GET
            // /productos/
            // /productos

            List<Producto> proList = proDAO.getAll();
            System.out.println("Productos: " + proList);
            req.setAttribute("listaProductos", proList);

            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
        } else {
            // GET
            // 		/productos/{id}
            // 		/productos/{id}/
            // 		/ptoductos/edit/{id}
            // 		/productos/edit/{id}/
            // 		/productos/crear
            // 		/productos/crear/

            path = path.replaceAll("/$", "");
            String[] pathParts = path.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                // GET
                // /productos/crear
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/producto-crear.jsp");
            } else if (pathParts.length == 2) {
                ProductoDAO proDAO = new ProductoDAOImpl();

                try {
                    int id = Integer.parseInt(pathParts[1]);
                    Optional<Producto> producto = proDAO.find(id);

                    req.setAttribute("producto", producto);
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/producto-detalle.jsp");
                } catch (NumberFormatException n) {
                    n.printStackTrace();
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                ProductoDAO proDAO = new ProductoDAOImpl();
                // GET
                // /productos/editar

                try {
                    req.setAttribute("producto", proDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/editar-producto.jsp");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");

            }
        }

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String __method__ = req.getParameter("__method__");

        if (__method__ != null) {
            ProductoDAO proDAO = new ProductoDAOImpl();

            String nombre = req.getParameter("nombre");
            Double precio = Double.parseDouble(req.getParameter("precio"));
            String descripcion = req.getParameter("descripcion");
            Integer idCategoria = Integer.parseInt(req.getParameter("idCategoria"));

            Producto producto = new Producto();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
            producto.setIdCategoria(idCategoria);

            proDAO.create(producto);
        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(req, resp);
        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(req, resp);
        } else {
            System.out.println("Opción POST no soportada.");
        }

        //response.sendRedirect("../../../tienda/productos");
        resp.sendRedirect(req.getContextPath() + "/comercio/productos");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoDAO proDAO = new ProductoDAOImpl();

        String ID = req.getParameter("ID");
        String nombre = req.getParameter("nombre");
        Double precio = Double.parseDouble(req.getParameter("precio"));
        String descripcion = req.getParameter("descripcion");

        Producto producto = new Producto();

        try {
            int id = Integer.parseInt(ID);
            producto.setIdProducto(id);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);

            proDAO.update(producto);
        } catch (NumberFormatException n) {
            n.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        ProductoDAO proDAO = new ProductoDAOImpl();

        String ID = req.getParameter("ID");

        try {
            int id = Integer.parseInt(ID);
            proDAO.delete(id);
        } catch (NumberFormatException n) {
            n.printStackTrace();
        }
    }
}
