package com.film.producer.core.service.impl;

import com.film.producer.core.dao.FilmReportDAO;
import com.film.producer.core.dao.FilmDAO;
import com.film.producer.core.model.data.FilmData;
import com.film.producer.core.model.data.FilmInventoryData;
import com.film.producer.core.service.FilmService;
import com.film.producer.core.service.transformer.FilmDataTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmReportDAO filmJdbcDAO;

    @Autowired
    private FilmDAO filmDAO;

    @Autowired
    private FilmDataTransformer filmDataTransformer;

    @Override
    public List<FilmInventoryData> getInventoryData() {
        return filmJdbcDAO.getInventoryData();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<FilmData> getAllFilms() {
        return filmDataTransformer.convert(filmDAO.getAllFilms());
    }
}
