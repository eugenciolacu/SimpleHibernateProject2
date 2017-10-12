package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session currentSession;
    private static Transaction currentTransaction;

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public static void closeCurrentSession() {
        currentSession.close();
    }

    public static void openCurrentTransaction() {
        currentTransaction = currentSession.beginTransaction();
    }

    public static void commitCurrentTransaction() {
        currentTransaction.commit();
    }
}