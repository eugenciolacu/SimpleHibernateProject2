package com.hibernate.dao;

import com.hibernate.entity.Dance;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DanceDao {
    private Session session;
    private Transaction transaction;

    public DanceDao(){

    }

    public void addDance(Dance dance){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.save(dance);
        transaction.commit();
        session.close();
    }

    public void editDance(Dance dance){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.update(dance);
        transaction.commit();
        session.close();
    }

    public void deleteDance(Dance dance){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.delete(dance);
        transaction.commit();
        session.close();
    }

    public Dance getById(long id){
        session = HibernateUtil.openCurrentSession();
        return session.get(Dance.class, id);
    }

    public List<Dance> getAll(){
        session = HibernateUtil.openCurrentSession();
        return session.createQuery("from Dance").list();
    }

    public void printAll(List<Dance> allDance){
        if(allDance.isEmpty())
            System.out.println("Table dance is empty");
        else
            for(Dance d : allDance)
                System.out.println(d);
    }
}
