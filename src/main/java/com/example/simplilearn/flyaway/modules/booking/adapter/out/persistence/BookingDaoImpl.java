package com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class BookingDaoImpl extends BookingDao {

    @Override
    public Booking read(int id) {
        System.out.println("Flight.add");
        Transaction transaction = null;
        Booking booking = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            booking = session.load(Booking.class, id);

            System.out.println("flight="+ booking);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return booking;
    }


    @Override
    public Booking update(Booking item) {

        Transaction transaction = null;
        Booking bookingToUpdate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(item == null) {
                return null;
            }

            bookingToUpdate = session.load(Booking.class, item.getBookingId());

            session.persist(bookingToUpdate);

            System.out.println("placeToUpdate="+ bookingToUpdate);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return bookingToUpdate;
    }

    protected String getQueryFindAll() {
        return "from Booking order by flight.departureTime";
    }
    protected String getQueryDelete() {
        return "delete from Booking where bookingId = :id";
    }


    public List<Booking> findBookingByUserId(Integer userId) {

        System.out.println("$$$$$$$$$IDao.findAll="+ getQueryFindAll());
        List<Booking> items = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Booking> query = session.createQuery("from Booking where user.userId = :userId order by flight.departureTime");
            query.setParameter("userId", userId);
            items = query.list();
            session.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return items;


    }
}
