package br.com.netfood_2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Elisiandro
 */
public class JpaUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Netfood_2PU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public static void close(){
        emf.close();
    }
}
