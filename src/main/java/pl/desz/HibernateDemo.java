package pl.desz;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.desz.entity.User;

import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {

        try {

            final Session session = HibernateUtil.getSessionFactory().openSession();
            final List<User> resultList = session.createQuery("from User", User.class).getResultList();

            System.out.println(resultList);
        } finally {
            HibernateUtil.close();
        }

    }
}
