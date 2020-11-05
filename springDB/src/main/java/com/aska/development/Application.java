package com.aska.development;

import com.aska.development.model.Song;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        final Song song = context.getBean(Song.class);

        System.out.println("Song :" + song.getName());
        System.out.println("Author :" + song.getAuthor());
    }
}
