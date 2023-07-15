package com.rxf113;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public List<Fruit> findBySeason(String season) {
        return find("upper(season)", season.toUpperCase()).list();
    }

    public List<Fruit> findNamesBySeason(String season) {
        PanacheQuery<Fruit> query = find("select name from Fruit where upper(season) = :season",
                Parameters.with("season", season.toUpperCase())).project(Fruit.class);
        return query.list();
    }
}