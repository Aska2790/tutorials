package com.aska.development.interactors;

import com.aska.development.dao.SongDao;

import java.util.Objects;

public class RemoveSongUseCase {
    //region Fields

    private SongDao mSongDao;

    //endregion

    //region Constructors

    public RemoveSongUseCase(SongDao songDao) {
        Objects.requireNonNull(songDao);
        mSongDao = songDao;
    }

    //endregion

    //region Methods

    public void invoke(){
        mSongDao.remove("Family");
    }

    //endregion
}
