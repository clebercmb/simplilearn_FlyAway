package com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


@Component
public class FlightDaoImpl extends FlightDao{


    @Override
    public Flight create(Flight item) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Place placeFrom = session.load(Place.class, item.getFrom().getPlaceId());
            Place placeTo = session.load(Place.class, item.getTo().getPlaceId());

            item.setFrom(placeFrom);
            item.setTo(placeTo);

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

    @Override
    public Flight read(int id) {
        System.out.println("Flight.add");
        Transaction transaction = null;
        Flight flight= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            flight = session.load(Flight.class, id);

            System.out.println("flight="+flight);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return flight;
    }


    @Override
    public Flight update(Flight item) {
        System.out.println("Flight.add");
        Transaction transaction = null;
        Flight flightToUpdate= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(item == null) {
                return null;
            }

            flightToUpdate = session.load(Flight.class, item.getFlightId());

            flightToUpdate.setFlightNumber(item.getFlightNumber());
            flightToUpdate.setArriveTime(item.getArriveTime());
            flightToUpdate.setDepartureTime(item.getDepartureTime());

            Place placeFrom = session.load(Place.class, item.getFrom().getPlaceId());
            Place placeTo = session.load(Place.class, item.getTo().getPlaceId());

            flightToUpdate.setFrom(placeFrom);
            flightToUpdate.setTo(placeTo);
            flightToUpdate.setSeatsCapacity(item.getSeatsCapacity());
            flightToUpdate.setTicketPrice(item.getTicketPrice());





            session.persist(flightToUpdate);

            System.out.println("flightToUpdate="+flightToUpdate);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return flightToUpdate;
    }

    protected String getQueryFindAll() {
        return "from Flight";
    }
    protected String getQueryDelete() {
        return "delete from Flight where flightId = :id";
    }

}
