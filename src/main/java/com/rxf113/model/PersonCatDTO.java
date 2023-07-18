package com.rxf113.model;

public class PersonCatDTO {
    private Person person;
    private Cat cat;

    public PersonCatDTO(Person person, Cat cat) {
        this.person = person;
        this.cat = cat;
    }

    public Person getPerson() {
        return person;
    }

    public Cat getCat() {
        return cat;
    }

    // Getters and setters
}
