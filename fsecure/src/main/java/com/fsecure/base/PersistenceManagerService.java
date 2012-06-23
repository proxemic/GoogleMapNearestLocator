/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.base;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author Dickson
 */
public class PersistenceManagerService {
    
    private static final PersistenceManagerService singleton = new PersistenceManagerService();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DATABASEPU");
    private static Logger logger = Logger.getLogger(PersistenceManagerService.class.getName());
    
    public static PersistenceManagerService getInstance() {
        return singleton;
    }
    
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
            logger.info("closeEntityManagerFactory @" + new Date());
        }
        
    }
}
