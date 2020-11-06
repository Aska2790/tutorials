package com.aska.development.db.spring;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SpringSongDao implements SongDao {

    //region Fields
    private static final String INSERT_SQL_QUERY = "INSERT INTO songs (name, author) VALUES (?,?)";
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
        return null;
    }

    @Override
    public List<Song> getAll(String author) {
        return null;
    }

    @Override
    public void add(Song songParam) {
        Objects.requireNonNull(songParam);
        mTemplate.update(INSERT_SQL_QUERY,
                songParam.getName(),
                songParam.getAuthor());
    }

    @Override
    public void remove(String name) {

    }

    //endregion
}
