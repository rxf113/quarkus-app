package com.rxf113.repository;

import com.rxf113.model.Cat;
import com.rxf113.model.Person;
import com.rxf113.model.PersonCatDTO;
import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {


    public  Uni<Person> findByName(String name){
        return find("id", 110).firstResult();
    }

    public Uni<Person> getPersonFullInfoById(String id) {
        return find("id", 110).firstResult();
//        PanacheQuery<Person> query = find("SELECT * FROM Person").project(Person.class);
//        Uni<List<Person>> list = query.list();
//        return list.onItem()
//                .transform(item -> item.stream().map(it -> {
//                    System.out.println(111);
//                    return it;
//                }).toList());
//        PanacheQuery<PersonCatDTO> query = find("SELECT p, c FROM Person p JOIN Cat c ON p.id = c.person.id WHERE p.id = :id",
//                Parameters.with("id", id)).project(PersonCatDTO.class);
//        Uni<List<PersonCatDTO>> list = query.list();
//        return list.onItem()
//                .transform(item -> item.stream().map(it -> {
//                    Cat cat = it.getCat();
//                    cat.setPerson(it.getPerson());
//                    return cat;
//                }).toList());
    }

}