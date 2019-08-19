package com.wenbronk.jpa01.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * describe:
 * wenbronk create at 2019/7/29 22:35
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("jpa_starter");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
