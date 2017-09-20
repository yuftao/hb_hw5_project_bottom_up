package hello;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static Context jndiContext;
    
    static {
        try {
            // Build it and bind it to JNDI
            new Configuration().buildSessionFactory();
            
            // Get a handle to the registry (reads jndi.properties)
            jndiContext = new InitialContext();
            
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(String sfName) {
        SessionFactory sf;
        
        try {
            sf = (SessionFactory) jndiContext.lookup(sfName);
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
        return sf;
    }
}
