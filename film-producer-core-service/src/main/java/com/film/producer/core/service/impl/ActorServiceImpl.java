package com.film.producer.core.service.impl;

import com.film.producer.core.dao.ActorDAO;
import com.film.producer.core.model.data.ActorData;
import com.film.producer.core.model.entity.Actor;
import com.film.producer.core.model.exception.ActorException;
import com.film.producer.core.service.ActorService;
import com.film.producer.core.service.transformer.ActorDataTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("actorService")
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDAO actorDAO;

    @Autowired
    private ActorDataTransformer actorTransformer;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ActorData> getAll() {
        final List<Actor> actors = actorDAO.getAll();
        return actorTransformer.convertActorToActorData(actors);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ActorData getById(final long actorId) {
        final Actor actor = actorDAO.getById(actorId);
        return actorTransformer.convertActorToActorData(actor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ActorData saveActor(final String firstName, final String lastName) {
        validateActorData(firstName, lastName);
        final Actor actor = new Actor();
        actor.setFirstName(firstName.toUpperCase());
        actor.setLastName(lastName.toUpperCase());
        actorDAO.saveOrUpdate(actor);
        final ActorData actorData = actorTransformer.convertActorToActorData(actor);
        return actorData;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ActorData updateActor(final long id, final String firstName, final String lastName) {
        validateActorData(firstName, lastName);
        final Actor actor = actorDAO.getById(id);
        if(actor == null) {
            throw new ActorException(ActorException.ActorExceptionType.ACTOR_NOT_FOUND);
        }
        actor.setFirstName(firstName.toUpperCase());
        actor.setLastName(lastName.toUpperCase());
        actorDAO.saveOrUpdate(actor);
        return actorTransformer.convertActorToActorData(actor);
    }

    private void validateActorData(final String firstName, final String lastName) {
        if(StringUtils.isEmpty(firstName)) {
            throw new ActorException(ActorException.ActorExceptionType.FIRST_NAME_EMPTY);
        }
        if(StringUtils.isEmpty(lastName)) {
            throw new ActorException(ActorException.ActorExceptionType.LAST_NAME_EMPTY);
        }
    }
}
