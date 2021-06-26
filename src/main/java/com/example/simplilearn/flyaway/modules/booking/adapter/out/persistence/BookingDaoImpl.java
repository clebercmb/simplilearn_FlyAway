package com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


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
        return "from Place order by name";
    }
    protected String getQueryDelete() {
        return "delete from Place where placeId = :id";
    }

}
