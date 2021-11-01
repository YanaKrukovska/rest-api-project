package com.krukovska.restapiproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findById(long id);

    List<Event> findAllByTitle(String title);
}
