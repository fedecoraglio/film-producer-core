package com.film.producer.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private long filmId;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "FILM_ACTOR",
            joinColumns = {@JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    private List<Actor> actors;


    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
