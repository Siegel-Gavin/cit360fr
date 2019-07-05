package code.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//This class use the session and save it to the database.

public class hibEmployee {
    private static SessionFactory factory;

    public hibEmployee(SessionFactory factory){
        this.factory = factory;
    }

    public Integer addPerson(String fname, String lname){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer personID = null;

        try {
            tx = session.beginTransaction();
            Person person = new Person();
            person.setFirstName(fname);
            person.setLastName(lname);
            personID = (Integer) session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personID;
    }
}