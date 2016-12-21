package com.film.producer.core.dao.impl.hibernate;

import com.film.producer.core.dao.ActorDAO;
import com.film.producer.core.model.entity.Actor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("actorDAO")
public class ActorDAOImpl implements ActorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Actor> getAll() {
        final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Actor.class);
        return criteria.list();
    }

    @Override
    public Actor getById(long id) {
        final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Actor.class);
        criteria.add(Restrictions.eq("id", id));
        return (Actor) criteria.uniqueResult();
    }

    @Override
    public void saveOrUpdate(final Actor actor) {
        final Session session = sessionFactory.getCurrentSession();
        actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        session.saveOrUpdate(actor);
        session.flush();

    }
}
