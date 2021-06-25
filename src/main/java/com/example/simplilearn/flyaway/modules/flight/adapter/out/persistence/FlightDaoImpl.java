package com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


    @Override
    public List<Flight> searchFlights(String from, String To, int numberOfPassengers, LocalDate departureDate, LocalDate returnDate) {

        Transaction transaction = null;

        List<Flight> flights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "SELECT a.*, b.name as from_place, c.name as to_place FROM flight a INNER JOIN place b ON a.place_id_from  = b.place_id INNER JOIN  place c on a.place_id_to = c.place_id WHERE b.name like :from_place";

            System.out.println(">>>>>SQL="+sql);
            flights = session.createNativeQuery(sql).addEntity(Flight.class).setParameter("from_place", "%"+from+"%").list();;
            //query.setParameter("from_place", from);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return flights;
    }
}
