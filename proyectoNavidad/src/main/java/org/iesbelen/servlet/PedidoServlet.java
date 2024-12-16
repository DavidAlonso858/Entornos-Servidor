package org.iesbelen.servlet;

import jakarta.ejb.Local;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.*;
import org.iesbelen.model.Pedido;
import org.iesbelen.utilities.Util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "pedidoServlet", value = "/comercio/pedidos/*")
public class PedidoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * /usuarios/
     * /usuarios/{id}
     * /usuarios/editar{id}
     * /usuarios/crear
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            PedidoDAO pedidoDAO = new PedidoDAOImpl();
            //GET
            //	/pedidos/
            //	/pedidos

            List<Pedido> listPedidos = pedidoDAO.getAll();


            request.setAttribute("listaPedidos", listPedidos);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/pedidos.jsp");


        } else {
            // GET
            // 		/pedidos/{id}
            // 		/pedidos/{id}/
            // 		/pedidos/edit/{id}
            // 		/pedidos/edit/{id}/
            // 		/pedidos/crear
            // 		/pedidos/crear/
            //      /pedidos/login
            //      /pedidos/login/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                // GET
                // /pedidos/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/crear-pedido.jsp");

            } else if (pathParts.length == 2) {
                PedidoDAO pedidoDAO = new PedidoDAOImpl();
                // GET
                // /pedidos/{id}
                try {
                    int id = Integer.parseInt(pathParts[1]); // almaceno la id
                    Optional<Pedido> pedidoOpt = pedidoDAO.find(id);

                    request.setAttribute("pedido", pedidoOpt);
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/detalle-pedido.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/pedidos.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                PedidoDAO pedidoDAO = new PedidoDAOImpl();
                // GET
                // /pedidos/editar/{id}
                try {
                    request.setAttribute("pedido", pedidoDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/editar-pedido.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/pedidos.jsp");
                }

            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/pedidos.jsp");

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
            PedidoDAO pedidoDAO = new PedidoDAOImpl();

            LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            Pedido nuevoPed = new Pedido();

            nuevoPed.setFecha(fecha);
            nuevoPed.setIdUsuario(idUsuario);

            pedidoDAO.create(nuevoPed);


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

        PedidoDAO pedidoDAO = new PedidoDAOImpl();

        Integer ID = Integer.parseInt(request.getParameter("ID"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Pedido ped = new Pedido();

        try {
            ped.setIdPedido(ID);
            ped.setFecha(fecha);
            ped.setIdUsuario(idUsuario);

            pedidoDAO.update(ped);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;

        PedidoDAO pedidoDAO = new PedidoDAOImpl();

        Integer idPed = Integer.parseInt(request.getParameter("ID")); // valor del name del form del usuario

        try {
            pedidoDAO.delete(idPed);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
