package com.example.simplilearn.flyaway.util;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

//CRUD
public abstract class IDao <T>{

    public T create(T item) {

        System.out.println(">>>IDao.add");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(item);

            System.out.println(">>>After save -> Item="+item);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return item;

    }

    public abstract T read(int id);


    public Set<T> readAll() {
        System.out.println("$$$$$$$$$IDao.findAll="+ getQueryFindAll());
        Set<T> items = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<T> query = session.createQuery(getQueryFindAll());
            items = new HashSet<T>(query.list());
            session.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return items;
    }

    public abstract T update(T item);
    public  void delete (int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query query = session.createQuery(getQueryDelete());
            query.setParameter("id", id);

            int result = query.executeUpdate();

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

    }

    protected abstract String getQueryFindAll();
    protected abstract String getQueryDelete();


}
