package com.aska.development.spring_jdbc;

import com.aska.development.spring_jdbc.dao.StudentDao;
import com.aska.development.spring_jdbc.db.dao.StudentTableUtil;
import com.aska.development.spring_jdbc.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Objects;

public class Application {
    //region Main

    public static void main(String[] args) throws ClassNotFoundException {


        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        final Application application = context.getBean(Application.class);
        try {
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //Destroy
        }
    }

    //endregion

    //region Fields

    private StudentTableUtil mStudentTableUtil;
    private StudentDao mStudentDao;

    //endregion

    //region Constructors

    public Application(StudentTableUtil studentTableUtil, StudentDao studentDao) {
        Objects.requireNonNull(studentTableUtil);
        Objects.requireNonNull(studentDao);

        mStudentTableUtil = studentTableUtil;
        mStudentDao = studentDao;
    }

    //endregion

    //region Methods

    public void run() throws Exception {

        mStudentTableUtil.create();

        printStudentList(new PrintImpl());

        mStudentDao.insert(new Student("Student 1", 17));
        mStudentDao.insert(new Student("Student 2", 18));
        mStudentDao.insert(new Student("Student 3", 19));

        Student student = new Student(4,"Student 4", 20);
        mStudentDao.insert(student);

        final PrintImpl print = new PrintImpl();
        printStudentList(print);

        student.setAge(21);
        mStudentDao.update(student);

        student = mStudentDao.select(4);
        print.print(student);

        mStudentDao.delete(student);
        printStudentList(print);

    }

    private void printStudentList(Print print) throws Exception {
        Objects.requireNonNull(print);
        final List<Student> students = mStudentDao.selectAll();
        if(students != null){
            for (Student student : students) {
                print.print(student);
            }
        }
    }
    //endregion

    private interface Print{
        void print(Student student);
    }

    private static class PrintImpl implements Print{
        @Override
        public void print(Student student) {
            System.out.println(
                    "\nStudent id : " + student.getId() +
                    "\nStudent name : " + student.getName() +
                    "\nStudent age : " + student.getAge()
            );
        }
    }
}
