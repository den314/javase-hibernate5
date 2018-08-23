package pl.desz;

import org.hibernate.Session;
import pl.desz.entity.Account;
import pl.desz.entity.Transaction;
import pl.desz.entity.User;

import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        final List<User> resultList = session.createQuery("from User", User.class).getResultList();

        System.out.println(resultList);

        List<Transaction> transactions = session.createQuery("from Transaction", Transaction.class).getResultList();
        System.out.println(transactions);

        List<Account> accounts = session.createQuery("from Account", Account.class).getResultList();
        System.out.println(accounts);
    }
}
