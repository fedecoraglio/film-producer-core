package com.film.producer.core.service;

import com.film.producer.core.model.data.ActorData;

import java.util.List;

public interface ActorService {

    List<ActorData> getAll();

    ActorData getById(final long actorId);

    ActorData saveActor(final String firstName, final String lastName);

    ActorData updateActor(final long id, final String firstName, final String lastName);
}
