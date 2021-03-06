package util;
import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Properties;

public class UserDaoFactory {
    public static UserDAO getUserDAO() throws IOException {

        Properties prop = new Properties();
        try(InputStream in = UserDaoFactory.class.getResourceAsStream("/config.properties"))
        {
            prop.load(in);
            String daoString = prop.getProperty("daotype");

            if (daoString.equals("jdbc")) {
                return new UserJdbcDAO(DBHelper.getConnection());
            } else {

                return new UserHibernateDAO(DBHelper.getSessionFactory());

            }
        }

    }
}
