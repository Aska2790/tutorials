package com.aska.development.db.jdbc;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;

import java.util.List;
import java.util.Optional;

public class JdbcSongDao implements SongDao {

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
    public void add(Song song) {

    }

    @Override
    public void remove(String name) {

    }

    //endregion
}
