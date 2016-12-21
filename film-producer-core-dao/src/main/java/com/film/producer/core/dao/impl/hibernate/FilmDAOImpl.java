package com.film.producer.core.dao.impl.hibernate;

import com.film.producer.core.dao.FilmDAO;
import com.film.producer.core.model.entity.Film;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Film> getAllFilms() {
        final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Film.class);
        return criteria.list();
    }
}
