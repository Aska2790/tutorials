package com.aska.development.db.spring;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SpringSongDao implements SongDao {

    //region Fields
    private JdbcTemplate mTemplate;

    //endregion

    //region Constructors

    public SpringSongDao(DataSource dataSource) {
        mTemplate = new JdbcTemplate(dataSource);
    }

    //endregion

    //region Methods

    @Override
    public Optional<Song> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Song> getAll() {
        String sqlQuery = "SELECT * FROM songs";
        return mTemplate.query(sqlQuery, new SongEntityMapper());
    }

    @Override
    public List<Song> getAll(String authorParam) {
        String sqlQuery = "SELECT * FROM songs WHERE author = ?";
        return mTemplate.query(sqlQuery, new SongEntityMapper(), authorParam);
    }

    @Override
    public void add(Song songParam) {
        Objects.requireNonNull(songParam);
        String sqlQuery = "INSERT INTO songs (name, author) VALUES (?,?)";
        mTemplate.update(sqlQuery, songParam.getName(), songParam.getAuthor());
    }

    @Override
    public void remove(String nameParam) {
        Objects.requireNonNull(nameParam);
        String sqlQuery = "DELETE FROM songs WHERE name = ?";
        mTemplate.update(sqlQuery, nameParam);
    }

    private static final class SongEntityMapper implements RowMapper<Song>{
        @Override
        public Song mapRow(ResultSet resultSet, int i) throws SQLException {
            final String name = resultSet.getString("name");
            final String author = resultSet.getString("author");
            return new Song(name, author);
        }
    }
    //endregion
}
