package util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory getSessionFactory() {

        var configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        return configuration.buildSessionFactory();
    }
}
