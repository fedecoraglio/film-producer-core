package com.film.producer.core.model.data;

import java.util.List;

public class FilmData {

    private final long filmId;
    private final String title;
    private final List<ActorData> actors;

    private FilmData(final Builder builder) {
        this.filmId = builder.filmId;
        this.title = builder.title;
        this.actors = builder.actors;
    }

    public static final class Builder {

        private long filmId;
        private String title;
        private List<ActorData> actors;

        public FilmData build() {
            return new FilmData(this);
        }

        public Builder withFilmId(long filmId) {
            this.filmId = filmId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withActors(List<ActorData> actors) {
            this.actors = actors;
            return this;
        }
    }

    public long getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public List<ActorData> getActors() {
        return actors;
    }
}
