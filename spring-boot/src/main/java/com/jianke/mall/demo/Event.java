package com.jianke.mall.demo;

public class Event {
    private Person person;

    public Event() {
    }

    public Event(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }

}