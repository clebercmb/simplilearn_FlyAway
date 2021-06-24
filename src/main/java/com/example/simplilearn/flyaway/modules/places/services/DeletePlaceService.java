package com.example.simplilearn.flyaway.modules.places.services;

import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import org.springframework.stereotype.Service;

@Service
public class DeletePlaceService {

    private final PlaceDao placeDao;

    public DeletePlaceService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public void execute(int id) {
        placeDao.delete(id);
    }

}
