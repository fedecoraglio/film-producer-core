package com.film.producer.core.model.mapper;

import com.film.producer.core.model.data.FilmInventoryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmReportMapper implements RowMapper<FilmInventoryData> {

    @Override
    public FilmInventoryData mapRow(final ResultSet resultSet, final int i) throws SQLException {
        return new FilmInventoryData.Builder()
                .withFilmId(resultSet.getLong("film_id"))
                .withFilmTitle(resultSet.getString("film_title"))
                .withInventoryNumber(resultSet.getLong("inventory_number"))
                .withStoreId(resultSet.getLong("store_id"))
                .withStoreAddress(resultSet.getString("store_address"))
                .build();
    }
}
