package com.rxf113;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Fruit extends PanacheEntity {

    public Fruit(String name) {
        this.name = name;
    }

    public String name;

    public String season;

    public Fruit() {

    }

    public static List<Fruit> findBySeason(String season) {
        return find("season", season).list();
    }

}