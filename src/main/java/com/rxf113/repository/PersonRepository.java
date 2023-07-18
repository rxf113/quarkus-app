package com.rxf113.repository;

import com.rxf113.model.Cat;
import com.rxf113.model.PersonCatDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Object> {

    public List<Cat> getPersonFullInfoById(String id) {
        PanacheQuery<PersonCatDTO> query = find("SELECT p, c FROM Person p JOIN Cat c ON p.id = c.person.id WHERE p.id = :id",
                Parameters.with("id", id)).project(PersonCatDTO.class);
        List<PersonCatDTO> resultList = query.list();
        if (!resultList.isEmpty()) {
            return resultList.stream().map(it -> {
                Cat cat = it.getCat();
                cat.setPerson(it.getPerson());
                return cat;
            }).toList();
        }
        return new ArrayList<>();

    }

}