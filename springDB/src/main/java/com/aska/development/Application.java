package com.aska.development;

import com.aska.development.interactors.*;
import com.aska.development.model.Song;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Objects;

public class Application {

    //region Main

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        final Application application = context.getBean(Application.class);
        application.run();
     }

    //endregion

    //region Fields

    private GetAllSongUseCase mGetAllUseCase;
    private GetAllAuthorSongsUseCase mGetAllAuthorSongsUseCase;
    private GetSongUseCase mGetUseCase;
    private InsertSongUseCase mInsertUseCase;
    private RemoveSongUseCase mRemoveUseCase;

    //endregion

    //region Constructors

    public Application(GetAllSongUseCase getAllUseCase,
                       GetAllAuthorSongsUseCase getAllAuthorSongsUseCase,
                       GetSongUseCase getUseCase,
                       InsertSongUseCase insertUseCase,
                       RemoveSongUseCase removeUseCase) {

        Objects.requireNonNull(getAllUseCase);
        Objects.requireNonNull(getAllAuthorSongsUseCase);
        Objects.requireNonNull(getUseCase);
        Objects.requireNonNull(getAllUseCase);
        Objects.requireNonNull(getAllUseCase);

        mGetAllUseCase = getAllUseCase;
        mGetAllAuthorSongsUseCase = getAllAuthorSongsUseCase;
        mGetUseCase = getUseCase;
        mInsertUseCase = insertUseCase;
        mRemoveUseCase = removeUseCase;
    }

    //endregion

    //region Methods

    public void run(){

//        mInsertUseCase.invoke();
//        final Song song = mGetUseCase.invoke();
//        System.out.println(song.toString());

        List<Song> songList = mGetAllAuthorSongsUseCase.invoke();
        songList.forEach(System.out::println);

//        songList = mGetAllUseCase.invoke();
//        songList.forEach(System.out::println);
//

//        mRemoveUseCase.invoke();

    }

    //endregion
}
