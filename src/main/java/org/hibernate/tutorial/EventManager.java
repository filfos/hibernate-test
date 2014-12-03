package org.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by fossufil on 02.12.2014.
 */
public class EventManager {
//    public static void main(String[] args) {
//        EventManager mgr = new EventManager();
//
////        if (args[0].equals("store")) {
////            mgr.createAndStoreEvent("My Event", new Date());
////        }
//        mgr.createAndStoreEvent("My Event", new Date());
//
//
//        HibernateUtil.getSessionFactory().close();
//    }

    public void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

    public Event getEventFromDb(long id){


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event event = (Event)session.get(Event.class, id);


        session.getTransaction().commit();
        return event;
    }

    public List<Event> getAllEvents(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> events = session.createCriteria(Event.class).list();

        session.getTransaction().commit();

        return events;
    }

}
