<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.DetallesPedido"%>
<%@page import="org.iesbelen.model.Producto"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.dao.ProductoDAO" %>
<%@ page import="org.iesbelen.dao.ProductoDAOImpl" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Detalles del Pedido</title>
  <%@ include file="../../../boostrap.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<main class="m-4">
  <section>
    <div class="container">
      <h1 class="fw-bold mb-4">Detalles del Pedido</h1>

      <%
        List<DetallesPedido> listaDetalles = (List<DetallesPedido>) request.getAttribute("listaDetallePedidos");
        double sumaTotal = 0.0;
      %>

      <div class="row">
        <%
          if (listaDetalles != null && !listaDetalles.isEmpty()) {
            for (DetallesPedido detalle : listaDetalles) {
              ProductoDAO productoDAO = new ProductoDAOImpl();
              Optional<Producto> pr = Optional.of(new Producto());
              pr = productoDAO.find(detalle.getIdProducto());
              double subtotal = detalle.getCantidad(); // Usar el campo de cantidad como subtotal
              sumaTotal += subtotal;
        %>
        <div class="col-md-4 mb-3">
          <div class="card h-100 shadow-sm">
            <div class="card-body">
              <h5 class="card-title"><%= detalle.getIdPedido() %></h5>
              <p class="card-text">
                Pelicula Blu-ray: <strong><%= pr.get().getNombre() %> </strong><br>
                Precio: <strong><%= detalle.getCantidad() %> €</strong><br>
                Subtotal: <strong><%= subtotal %> €</strong>
              </p>
            </div>
          </div>
        </div>
        <%
          }
        } else {
        %>
        <!-- Mostrar un mensaje si no hay detalles -->
        <div class="col-12">
          <p class="text-center text-muted">No hay detalles de pedido registrados.</p>
        </div>
        <% } %>
      </div>

      <!-- Mostrar suma total -->
      <div class="mt-4">
        <h3 class="text-end fst-italic">Suma Total: <strong><%= sumaTotal %> €</strong></h3>
      </div>
    </div>
  </section>
</main>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

</body>
</html>