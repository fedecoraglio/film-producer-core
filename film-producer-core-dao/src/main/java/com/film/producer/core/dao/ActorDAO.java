package com.film.producer.core.dao;

import com.film.producer.core.model.entity.Actor;

import java.util.List;

public interface ActorDAO {

    List<Actor> getAll();

    Actor getById(final long id);

    void saveOrUpdate(final Actor actor);
}
