package com.film.producer.core.dao.impl.jdbc;

import com.film.producer.core.dao.FilmReportDAO;
import com.film.producer.core.model.data.FilmInventoryData;
import com.film.producer.core.model.mapper.FilmReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository("filmJdbcDAO")
public class FilmJdbcDAO extends JdbcDaoSupport implements FilmReportDAO {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<FilmInventoryData> getInventoryData() {
        final List<FilmInventoryData> result =
                getJdbcTemplate().query(SQL_FILM_INVENTORY_REPORT, new FilmReportMapper());
        return result;
    }

    private static final String SQL_FILM_INVENTORY_REPORT =
            " SELECT fil.film_id, sto.store_id, addr.address as store_address, fil.title as film_title," +
                    "count(*) as inventory_number" +
            " FROM inventory inv, film fil, store sto, address addr " +
            " WHERE inv.film_id = fil.film_id AND sto.store_id = inv.store_id AND addr.address_id = sto.address_id " +
            " GROUP BY fil.film_id, sto.store_id, store_address, fil.title ";
}
