package org.iesbelen;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootWebMvcJdbcVentasApplication implements CommandLineRunner {

    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private ComercialDAO comercialDAO;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcJdbcVentasApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("*******************************");
        log.info("*Prueba de arranque ClienteDAO*");
        log.info("*******************************");

        clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));

        int id = 1;
        Optional<Cliente> cliente = clienteDAO.find(id);

        if (cliente.isPresent()) {
            log.info("Cliente {}: {}", id, cliente.get());

            String nombreOld = cliente.get().getNombre();

            cliente.get().setNombre("Jose M");

            clienteDAO.update(cliente.get());

            cliente = clienteDAO.find(id);

            log.info("Cliente {}: {}", id, cliente.get());

            //Volvemos a cargar el nombre antiguo..
            cliente.get().setNombre(nombreOld);
            clienteDAO.update(cliente.get());

        }

        // Como es un cliente nuevo a persistir, id a 0
        Cliente clienteNew = new Cliente(0, "Jose M", "Martín", null, "Málaga", 100);

        //create actualiza el id
        clienteDAO.create(clienteNew);

        log.info("Cliente nuevo con id = {}", clienteNew.getId());

        clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));

        //borrando por el id obtenido de create
        clienteDAO.delete(clienteNew.getId());

        clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));

        log.info("************************************");
        log.info("*FIN: Prueba de arranque ClienteDAO*");
        log.info("************************************");

        log.info("\n\n*******************************");
        log.info("*Prueba de arranque ComercialDAO*");
        log.info("*******************************");

        comercialDAO.getAll().forEach(co -> log.info("Comercial: {}", co)); // pruebo el listado

        int idComercial = 1;

        Optional<Comercial> comercial = comercialDAO.find(id);

        if (comercial.isPresent()) {
            log.info("Comercial {}: {}", idComercial, comercial.get());
            // la info del comerical devuelto por el Optional gracias al jdbcTempalte.queryFromObject

            BigDecimal comisionAntigua = comercial.get().getComision();
         //   comercial.get().setComision(0.22);

            comercialDAO.update(comercial.get());

            comercial = comercialDAO.find(idComercial);

            log.info("Comercial {}: {}", idComercial, comercial.get());

            //Volvemos a cargar la comision antiguo..
            comercial.get().setComision(comisionAntigua);
            comercialDAO.update(comercial.get());
        }
        // Como es un cliente nuevo a persistir, id a 0
      //  Comercial comercialNuevo = new Comercial(0, "David", "Alonso", "García", 2);

        //create actualiza el id
     //   comercialDAO.create(comercialNuevo);

       // log.info("Comercial nuevo con id = {}", comercialNuevo.getId());

        comercialDAO.getAll().forEach(co -> log.info("Comercial: {}", co));

        //borrando por el id obtenido de create
       // comercialDAO.delete(comercialNuevo.getId());

        comercialDAO.getAll().forEach(co -> log.info("Comercial: {}", co));
        log.info("************************************");
        log.info("*FIN: Prueba de arranque ComercialDAO*");
        log.info("************************************");
    }

}

