package com.aska.development.interactors;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;

import java.util.List;
import java.util.Objects;

public class GetAllAuthorSongsUseCase {
    //region Fields

    private SongDao mSongDao;

    //endregion

    //region Constructors

    public GetAllAuthorSongsUseCase(SongDao songDao) {
        Objects.requireNonNull(songDao);
        mSongDao = songDao;
    }

    //endregion

    //region Methods

    public List<Song> invoke() {
        return mSongDao.getAll("Bumboks");
    }

    //endregion
}
