package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.*;
import org.iesbelen.model.DetallesPedido;
import org.iesbelen.model.Pedido;
import org.iesbelen.utilities.Util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "detallePedidoServlet", value = "/comercio/detallepedidos/*")
public class DetallePedidoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * /detallepedido/
     * /detallepedidos/{id}
     * /detallepedidos/editar{id}
     * /detallepedidos/crear
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //
        HttpSession session = request.getSession(false);
        Object usuarioLogueado = (session != null) ? session.getAttribute("usuario-logado") : null;

        if (pathInfo == null || "/".equals(pathInfo)) {
            DetallePedidoDAO dpDAO = new DetallePedidoDAOImpl();
            //GET
            //	/detallepedidos/
            //	/detallepedidos

            List<DetallesPedido> listDetallePedido = dpDAO.getAll();


            request.setAttribute("listaDetallePedidos", listDetallePedido);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/detallepedidos.jsp");


        } else {
            // GET
            // 		/detallepedidos/{id}
            // 		/detallepedidos/{id}/
            // 		/detallepedidos/edit/{id}
            // 		/detallepedidos/edit/{id}/
            // 		/detallepedidos/crear
            // 		/detallepedidos/crear/
            //      /detallepedidos/login
            //      /detallepedidos/login/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                // GET
                // /detallepedidos/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/crear-detallepedido.jsp");

            } else if (pathParts.length == 2) {
                DetallePedidoDAO dtDAO = new DetallePedidoDAOImpl();
                // GET
                // /detallepedidos/{id}
                try {
                    int id = Integer.parseInt(pathParts[1]); // almaceno la id
                    Optional<DetallesPedido> dt = dtDAO.find(id);

                    request.setAttribute("detallepedidos", dt);
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/detalle-detallepedido.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                DetallePedidoDAO dtDAO = new DetallePedidoDAOImpl();
                // GET
                // /detallepedidos/editar/{id}
                try {
                    request.setAttribute("detallepedido", dtDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/editar-detallepedidos.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/detallepedidos.jsp");
                }

            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallepedidos/detallepedidos.jsp");

            }
        }

        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");
        HttpSession session = request.getSession(true);

        if (__method__ == null) {
            // Crear uno nuevo
            DetallePedidoDAO dtDAO = new DetallePedidoDAOImpl();

            Integer cantidad = Integer.parseInt(request.getParameter("usuario"));
            Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
            Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));

            DetallesPedido dt = new DetallesPedido();
            // Hashear la contraseña antes de almacenarla

            dt.setCantidad(cantidad);
            dt.setIdPedido(idPedido);
            dt.setIdProducto(idProducto);

            dtDAO.create(dt);

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

        //response.sendRvvedirect("../../..suarios");
        response.sendRedirect(request.getContextPath() + "/tienda/usuarios");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DetallePedidoDAO dtDAO = new DetallePedidoDAOImpl();
        Integer ID = Integer.parseInt(request.getParameter("ID"));
        Integer cantidad = Integer.parseInt(request.getParameter("usuario"));
        Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));

        DetallesPedido dt = new DetallesPedido();

        try {
            dt.setId(ID);
            dt.setCantidad(cantidad);
            dt.setIdProducto(idProducto);
            dt.setIdPedido(idPedido);
            dtDAO.update(dt);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        DetallePedidoDAO dtDAO = new DetallePedidoDAOImpl();
        String idUsu = request.getParameter("ID"); // valor del name del form del usuario

        try {

            int id = Integer.parseInt(idUsu);

            dtDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}