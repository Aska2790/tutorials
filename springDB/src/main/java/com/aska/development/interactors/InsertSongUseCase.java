package com.aska.development.interactors;

import com.aska.development.dao.SongDao;
import com.aska.development.model.Song;

import java.util.Objects;

public class InsertSongUseCase {

    //region Fields

    private SongDao mSongDao;

    //endregion

    //region Constructors

    public InsertSongUseCase(SongDao songDao) {
        Objects.requireNonNull(songDao);
        mSongDao = songDao;
    }

    //endregion

    //region Methods

    public void invoke(){
          mSongDao.add(new Song("Family", "Pink"));
        mSongDao.add(new Song("Life", "Zivert"));
        mSongDao.add(new Song("Some song", "Basta"));
        mSongDao.add(new Song("Wahteram", "Bumboks"));
    }

    //endregion
}
