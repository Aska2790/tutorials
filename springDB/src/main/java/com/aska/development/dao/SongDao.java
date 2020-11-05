package com.aska.development.dao;

import com.aska.development.model.Song;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface SongDao {

    /**
     * Получить песню с указанным в параметре именем<br>
     *
     * @param name имя песни
     * @return null если такого
     * @throws NullPointerException переданный параметр null
     */
    Optional<Song> getByName(String name);

    /**
     * Получить список всех песен в хранилище<br>
     *
     * @return список песен
     */
    @NonNull
    List<Song> getAll();

    /**
     * Получить песни указанного в параметре автора<br>
     *
     * @param author автор песен
     * @return null если такого
     * @throws NullPointerException переданный параметр null
     */
    @NonNull
    List<Song> getAll(String author);

    /**
     * Добавить в хранилище  новую песню <br>
     *
     * @param song песня для добавления
     * @throws NullPointerException     переданный параметр null
     * @throws IllegalArgumentException некорректное параметр запроса
     */
    void add(Song song);

    /**
     * Удалить с хранилища песню с именем указанным в параметре<br>
     *
     * @param name имя песни для удаление
     * @throws NullPointerException переданный параметр null
     */
    void remove(String name);


}
