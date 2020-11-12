package com.aska.development.spring_jdbc;

import com.aska.development.spring_jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    //region Main

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        final Application application = context.getBean(Application.class);
        application.run();
    }

    //endregion

    //region Fields

    private StudentDao mStudentDao;

    //endregion

    //region Constructors

    public Application(StudentDao studentDao) {
        mStudentDao = studentDao;
    }

    //endregion

    //region Methods

    public void run(){

    }

    //endregion
}
