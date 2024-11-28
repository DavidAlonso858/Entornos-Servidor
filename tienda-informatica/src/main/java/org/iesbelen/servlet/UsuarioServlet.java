package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.*;
import org.iesbelen.model.Fabricante;
import org.iesbelen.model.Producto;
import org.iesbelen.model.Usuario;
import org.iesbelen.utilities.Util;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "usuarioServlet", value = "/tienda/usuarios/*")
public class UsuarioServlet extends HttpServlet {

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
            UsuarioDAO usurDAO = new UsuarioDAOImpl();

            //GET
            //	/usuarios/
            //	/usuarios

            List<Usuario> listaUsuarios = usurDAO.getAll();


            request.setAttribute("listaUsuarios", listaUsuarios);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");


        } else {
            // GET
            // 		/usuarios/{id}
            // 		/usuarios/{id}/
            // 		/usuarios/edit/{id}
            // 		/usuarios/edit/{id}/
            // 		/usuarios/crear
            // 		/usuarios/crear/
            //      /usuarios/login
            //      /usuarios/login/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                // GET
                // /usuarios/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/crear-usuario.jsp");
            } else if (pathParts.length == 2 && "login".equals(pathParts[1])) {
                // GET
                // /usuarios/login
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/login.jsp");

            } else if (pathParts.length == 2) {
                UsuarioDAO usuDAO = new UsuarioDAOImpl();
                // GET
                // /usuarios/{id}
                try {
                    int id = Integer.parseInt(pathParts[1]); // almaceno la id
                    Optional<Usuario> usuario = usuDAO.find(id);

                    request.setAttribute("usuario", usuario);
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/detalle-usuario.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                UsuarioDAO usuDAO = new UsuarioDAOImpl();

                // GET
                // /usuarios/editar/{id}
                try {
                    request.setAttribute("usuario", usuDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/editar-usuario.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }

            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

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
            UsuarioDAO usuDAO = new UsuarioDAOImpl();

            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String rol = request.getParameter("rol");

            Usuario nuevoUsu = new Usuario();
            try {
                // Hashear la contraseña antes de almacenarla
                String hashedPassword = Util.hashPassword(password); // importada la clase

                nuevoUsu.setPassword(hashedPassword);  // Establecer la contraseña hasheada

                nuevoUsu.setUsuario(usuario);
                nuevoUsu.setRol(rol);
                usuDAO.create(nuevoUsu);  // Insertar con la contraseña hasheada

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace(); // Manejar errores en el hash
            }

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            // Borrar uno existente
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
            doDelete(request, response);
        } else if (__method__ != null && "login".equalsIgnoreCase(__method__)) {
            // Login
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
            UsuarioDAO usuDAO = new UsuarioDAOImpl();
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            try {
                String password2 = Util.hashPassword(password);
                Optional<Usuario> usuOpt = usuDAO.findLogin(usuario);
                System.out.println("Password hasheado (de entrada): " + password);
                System.out.println("Password almacenado en BD: " + usuOpt.get().getPassword());

                if (usuOpt.get().getPassword().equals(password2)) {
                    if (usuOpt.isPresent()) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("usuario-logado", usuOpt);
                        System.out.println("Hola");
                    } else {
                        // Usuario o contraseña incorrectos
                        request.setAttribute("error", "Usuario o contraseña incorrectos.");
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("Opción POST no soportada.");
        }

        //response.sendRedirect("../../../tienda/usuarios");
        response.sendRedirect(request.getContextPath() + "/tienda/usuarios");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO usuDao = new UsuarioDAOImpl();
        String idUsuario = request.getParameter("idUsuario");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        Usuario usu = new Usuario();

        try {
            int id = Integer.parseInt(idUsuario);
            usu.setIdUsuario(id);
            usu.setUsuario(usuario);
            usu.setPassword(Util.hashPassword(password));
            usu.setRol(rol);
            usuDao.update(usu);

        } catch (NumberFormatException | NoSuchAlgorithmException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        UsuarioDAO usuDAO = new UsuarioDAOImpl();
        String idUsu = request.getParameter("idUsuario"); // valor del name del form del usuario

        try {

            int id = Integer.parseInt(idUsu);

            usuDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}


