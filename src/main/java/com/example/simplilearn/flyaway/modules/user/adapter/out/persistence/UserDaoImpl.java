package com.example.simplilearn.flyaway.modules.user.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImpl extends UserDao {

    @Override
    public User read(int id) {
        System.out.println("Flight.add");
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.load(User.class, id);

            System.out.println("flight="+ user);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return user;
    }


    @Override
    public User update(User item) {

        Transaction transaction = null;
        User userToUpdate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(item == null) {
                return null;
            }

            userToUpdate = session.load(User.class, item.getPlaceId());

            userToUpdate.setName(item.getName());

            session.persist(userToUpdate);

            System.out.println("placeToUpdate="+ userToUpdate);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return userToUpdate;
    }

    protected String getQueryFindAll() {
        return "from Place order by name";
    }
    protected String getQueryDelete() {
        return "delete from Place where placeId = :id";
    }

}
