package com.film.producer.core.service.transformer;

import com.film.producer.core.model.data.FilmData;
import com.film.producer.core.model.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmDataTransformer {

    @Autowired
    private ActorDataTransformer actorDataTransformer;

    public List<FilmData> convert(final List<Film> films) {
        final List<FilmData> filmsData;
        if(films != null && films.size() > 0) {
            filmsData = new ArrayList<>(films.size());
            for(final Film film: films) {
                final FilmData filmData = new FilmData.Builder()
                        .withFilmId(film.getFilmId())
                        .withTitle(film.getTitle())
                        .withActors(actorDataTransformer.convertActorToActorData(film.getActors()))
                        .build();
                filmsData.add(filmData);
            }
        } else {
            filmsData = new ArrayList<>(0);
        }
        return filmsData;
    }
}
