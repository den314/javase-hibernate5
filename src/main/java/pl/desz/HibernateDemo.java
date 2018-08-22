package pl.desz;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.Query;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) throws SQLException {
        DataSource ds = dataSourceSetup();
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from T1");


        while (rs.next()) {
            System.out.println(rs.getString(1));
        }


        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Query query = session.createSQLQuery("SELECT * FROM T1");
        List resultList = query.getResultList();
        System.out.println(resultList);

    }

    private static DataSource dataSourceSetup() {
        System.out.println("exec");
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'src/main/resources/create.sql'\\;RUNSCRIPT FROM 'src/main/resources/init.sql'");
        ds.setUsername("sa");

        return ds;
    }
}
