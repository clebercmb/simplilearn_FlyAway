package com.example.simplilearn.flyaway.modules.user.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;


@Component
public class UserDaoImpl extends UserDao {

    @Override
    public User read(int id) {
        System.out.println("User.add");
        Transaction transaction = null;
        User user;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.load(User.class, id);

            System.out.println("user="+ user);

            transaction.commit();
            session.close();
        } catch (ObjectNotFoundException ex) {
            System.out.println(">>>>>Not found user id="+id);
            return null;
        }
        catch (Exception ex) {
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
        User userToUpdate;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(item == null) {
                return null;
            }

            userToUpdate = session.load(User.class, item.getUserId());

            userToUpdate.setName(item.getName());

            session.persist(userToUpdate);

            System.out.println("userToUpdate="+ userToUpdate);

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
        return "from User order by name";
    }
    protected String getQueryDelete() {
        return "delete from User where userId = :id";
    }


    public User findByEmail(String email) {

        System.out.println("User.add");
        Transaction transaction = null;
        User user;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = (User) session.createQuery("from User where email = :email")
                    .setParameter("email", email)
                    .getSingleResult();

            //user = session.load(User.class, email);

            System.out.println("user="+ user);

            transaction.commit();
            session.close();

        } catch (ObjectNotFoundException | NoResultException ex) {
            System.out.println(">>>>>Not found email ="+email);
            return null;
        }
        catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return user;


    }


}
