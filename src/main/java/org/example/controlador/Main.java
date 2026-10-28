package org.example.controlador;

import org.example.modelo.Cliente;
import org.example.modelo.Empleado;
import org.example.modelo.Producto;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("vistas/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        get("/", (req, res) -> {
            Context context = new Context();
            context.setVariable("usuario", "Bryann");
            return templateEngine.process("index", context);
        });

        get("/productos", (req, res) -> {
            Context context = new Context();
            List<Producto> lista = Arrays.asList(
                    new Producto(1, "Laptop Gamer", 1200.00),
                    new Producto(2, "Teclado Mecánico", 45.50),
                    new Producto(3, "Mouse Inalámbrico", 25.00)
            );
            context.setVariable("productos", lista);
            return templateEngine.process("productos", context);
        });

        get("/clientes", (req, res) -> {
            Context context = new Context();
            List<Cliente> lista = Arrays.asList(
                    new Cliente(101, "Carlos Pérez", "carlos@mail.com"),
                    new Cliente(102, "María Gómez", "maria@mail.com")
            );
            context.setVariable("clientes", lista);
            return templateEngine.process("clientes", context);
        });

        get("/empleados", (req, res) -> {
            Context context = new Context();
            List<Empleado> lista = Arrays.asList(
                    new Empleado(1, "Ana Torres", "Desarrolladora"),
                    new Empleado(2, "Luis Ramirez", "Soporte Técnico")
            );
            context.setVariable("empleados", lista);
            return templateEngine.process("empleados", context);
        });

        System.out.println("Servidor de Bryann iniciado en http://localhost:8080");
    }
}