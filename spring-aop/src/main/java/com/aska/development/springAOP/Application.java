package com.aska.development.springAOP;

import com.aska.development.springAOP.domain.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan
@Configuration
public class Application {
    //region Main

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

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
        System.out.println("Running");
        System.out.println(mStudentDao.select(1));
        System.out.println(mStudentDao.select(2));
        System.out.println(mStudentDao.select(3));
    }
    //endregion
}
