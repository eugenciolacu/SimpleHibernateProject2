package com.hibernate.dao;

import com.hibernate.entity.Man;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ManDao {

    private Session session;
    private Transaction transaction;

    public ManDao(){

    }

    public void addMan(Man man){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.save(man);
        transaction.commit();
        session.close();
    }

    public void editMan(Man man){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.update(man);
        transaction.commit();
        session.close();
    }

    public void deleteMan(Man man){
        session = HibernateUtil.openCurrentSession();
        transaction = session.beginTransaction();
        session.delete(man);
        transaction.commit();
        session.close();
    }

    public Man getById(long id){
        session = HibernateUtil.openCurrentSession();
        return session.get(Man.class, id);
    }

    public List<Man> getAll(){
        session = HibernateUtil.openCurrentSession();
        return session.createQuery("from Man").list();
    }

    public void printAll(List<Man> allMan){
        if(allMan.isEmpty())
            System.out.println("Table man is empty");
        else
            for(Man m : allMan)
                System.out.println(m);
    }
}
