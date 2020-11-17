package com.aska.development.interactors;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;

import java.util.Objects;

public class GetSongUseCase {
    //region Fields

    private SongDao mSongDao;

    //endregion

    //region Constructors

    public GetSongUseCase(SongDao songDao) {
        Objects.requireNonNull(songDao);
        mSongDao = songDao;
    }

    //endregion

    //region Methods

    public Song invoke(){
        return mSongDao.getByName("Life").orElse(null);
    }

    //endregion
}
