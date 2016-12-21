package com.film.producer.core.dao;

import com.film.producer.core.model.data.FilmInventoryData;

import java.util.List;

public interface FilmReportDAO {

    List<FilmInventoryData> getInventoryData();
}
