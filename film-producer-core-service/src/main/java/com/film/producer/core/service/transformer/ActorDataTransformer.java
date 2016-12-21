package com.film.producer.core.service.transformer;

import com.film.producer.core.model.data.ActorData;
import com.film.producer.core.model.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class ActorDataTransformer {

    public List<ActorData> convertActorToActorData(final List<Actor> actors) {
        final List<ActorData> actorsData;
        if(actors != null && actors.size() > 0) {
            actorsData = new ArrayList<>(actors.size());
            for(final Actor actor: actors) {
                final ActorData actorData = convertActorToActorData(actor);
                if(actorData != null) {
                    actorsData.add(actorData);
                }
            }
        } else {
            actorsData = new ArrayList<>(0);
        }
        return actorsData;
    }

    public ActorData convertActorToActorData(final Actor actor) {
        ActorData actorData = null;
        if(actor != null) {
            actorData = new ActorData.Builder()
                    .withId(actor.getId())
                    .withFirstName(actor.getFirstName())
                    .withLastName(actor.getLastName())
                    .build();
        }
        return actorData;
    }
}
