package com.film.producer.core.service;

import com.film.producer.core.model.data.FilmData;
import com.film.producer.core.model.data.FilmInventoryData;

import java.util.List;

public interface FilmService {

    List<FilmInventoryData> getInventoryData();

    List<FilmData> getAllFilms();
}
