package org.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fossufil on 02.12.2014.
 */
@javax.servlet.annotation.WebServlet(name = "Demo")
public class Servlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Set response content type
        response.setContentType("text/html");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(new Event());
        session.getTransaction().commit();

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
    public void destroy()
    {
        // do nothing.
    }
}
