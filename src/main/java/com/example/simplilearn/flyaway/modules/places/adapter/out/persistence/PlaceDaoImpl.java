package com.example.simplilearn.flyaway.modules.places.adapter.out.persistence;

import com.example.simplilearn.flyaway.config.HibernateUtil;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


@Component
public class PlaceDaoImpl extends PlaceDao {

    @Override
    public Place read(int id) {
        System.out.println("Flight.add");
        Transaction transaction = null;
        Place place = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            place = session.load(Place.class, id);

            System.out.println("flight="+ place);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return place;
    }


    @Override
    public Place update(Place item) {

        Transaction transaction = null;
        Place placeToUpdate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(item == null) {
                return null;
            }

            placeToUpdate = session.load(Place.class, item.getPlaceId());

            placeToUpdate.setName(item.getName());

            session.persist(placeToUpdate);

            System.out.println("placeToUpdate="+ placeToUpdate);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        return placeToUpdate;
    }

    protected String getQueryFindAll() {
        return "from Place";
    }
    protected String getQueryDelete() {
        return "delete from Place where placeId = :id";
    }

}
