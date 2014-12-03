package org.hibernate.tutorial;

import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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

        EventManager eventManager = new EventManager();
        eventManager.createAndStoreEvent("Heyo, I'm a title", new Date());
        eventManager.createAndStoreEvent("test test ææøå", new Date());

        List<Event> asdf = eventManager.getAllEvents();
        System.out.println(asdf);


        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (int i = 0; i < 10; i++){
            sb.append("<li>"+i+"</li>");
        }
        sb.append("</ul>");
        out.print(sb);

        out.print("<div>"+eventManager.getEventFromDb(9).getTitle()+"</div>");

    }
    public void destroy()
    {
        HibernateUtil.getSessionFactory().close();
        // do nothing.
    }
}
