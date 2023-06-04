package io.mk.contacts;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

import io.mk.contacts.entities.Contact;
import io.mk.contacts.services.ContactService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.service.spi.InjectService;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @PersistenceContext(name="default")
    private EntityManagerProducer emp;

    @PersistenceContext(name="default")
    private EntityManager em;

    @Inject
    private ContactService service;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        service.findCompany();

        List<Contact> list = emp.create().createQuery(
                "select c from contact c",
                Contact.class
        ).getResultList();


        System.out.println(list);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}