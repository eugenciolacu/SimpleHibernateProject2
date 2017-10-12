package com.hibernate.dao;

import com.hibernate.entity.Woman;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WomanDao {
    private Session session;
    private Transaction transaction;

    public WomanDao(){

    }

    public void addWoman(Woman woman){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.save(woman);
        transaction.commit();
        session.close();
    }

    public void editWoman(Woman woman){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.update(woman);
        transaction.commit();
        session.close();
    }

    public void deleteWoman(Woman woman){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.delete(woman);
        transaction.commit();
        session.close();
    }

    public Woman getById(long id){
        session = HibernateUtil.openCurrentSession();
        return session.get(Woman.class, id);
    }

    public List<Woman> getAll(){
        session = HibernateUtil.openCurrentSession();
        return session.createQuery("from Woman").list();
    }

    public void printAll(List<Woman> allWoman){
        if(allWoman.isEmpty())
            System.out.println("Table woman is empty");
        else
            for(Woman w : allWoman)
                System.out.println(w);
    }
}
