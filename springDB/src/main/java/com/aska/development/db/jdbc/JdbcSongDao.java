package com.aska.development.db.jdbc;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JdbcSongDao implements SongDao {

    //region Fields

    private ConnectionProvider mConnectionProvider;
    private static final String INSERT_SQL_QUERY = "INSERT INTO songs (name, author) VALUES (?,?)";
    private static final String SELECT_ALL_SQL_QUERY = "SELECT *FROM songs";
    private static final String SELECT_BY_NAME_SQL_QUERY = "SELECT *FROM songs WHERE name = ?";
    private static final String REMOVE_BY_NAME_SQL_QUERY = "DELETE FROM songs WHERE name = ?";

    //endregion

    //region Constructors

    public JdbcSongDao(ConnectionProvider connectionProvider) {
        mConnectionProvider = connectionProvider;
    }

    //endregion

    //region Methods

    @Override
    public Optional<Song> getByName(String nameParam) {
        Objects.requireNonNull(nameParam);
        try (PreparedStatement preparedStatement = mConnectionProvider
                .getConnection()
                .prepareStatement(SELECT_BY_NAME_SQL_QUERY);) {

            preparedStatement.setString(1, nameParam);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                final String name = resultSet.getString("name");
                final String author = resultSet.getString("author");
                return Optional.of(new Song(name, author));
            }else{
                return Optional.empty();
            }
        } catch (SQLException ignored) {
            return Optional.empty();
        }
    }

    @Override
    public List<Song> getAll() {
        try (PreparedStatement preparedStatement = mConnectionProvider
                .getConnection()
                .prepareStatement(SELECT_ALL_SQL_QUERY);) {
            List<Song> items = new ArrayList<>();
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                final String name = resultSet.getString("name");
                final String author = resultSet.getString("author");
                items.add(new Song(name, author));
            }
            return items;
        } catch (SQLException ignored) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Song> getAll(String authorParam) {
        Objects.requireNonNull(authorParam);
        List<Song> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = mConnectionProvider
                .getConnection()
                .prepareStatement(SELECT_ALL_SQL_QUERY);) {

            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                final String name = resultSet.getString("name");
                final String author = resultSet.getString("author");
                if(author.equals(authorParam)) {
                    items.add(new Song(name, author));
                }
            }
            return items;
        } catch (SQLException ignored) {
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Song song) {
        Objects.requireNonNull(song);
        if(song.getAuthor() == null || song.getName() == null){
            throw new IllegalArgumentException();
        }
        try (PreparedStatement preparedStatement = mConnectionProvider
                        .getConnection()
                        .prepareStatement(INSERT_SQL_QUERY);) {
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getAuthor());
            final int addedItemCount = preparedStatement.executeUpdate();
            if(addedItemCount <= 0 ){
                throw new IllegalStateException();
            }
        } catch (SQLException ignored) {}
    }

    @Override
    public void remove(String nameParam) {
        Objects.requireNonNull(nameParam);
        try (PreparedStatement preparedStatement = mConnectionProvider
                .getConnection()
                .prepareStatement(REMOVE_BY_NAME_SQL_QUERY);) {
            preparedStatement.setString(1, nameParam);
            final int removedItemCount = preparedStatement.executeUpdate();
            if(removedItemCount <= 0 ){
                throw new IllegalArgumentException();
            }
        } catch (SQLException ignored) {}
    }

    //endregion
}
