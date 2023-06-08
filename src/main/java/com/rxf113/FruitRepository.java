package com.rxf113;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public List<Fruit> findBySeason(String season) {
        return find("upper(season)", season.toUpperCase()).list();
    }

}