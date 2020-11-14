package com.aska.development.spring_jdbc;

import com.aska.development.spring_jdbc.dao.StudentDao;
import com.aska.development.spring_jdbc.db.dao.StudentTableUtil;
import com.aska.development.spring_jdbc.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
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

        Student student = new Student(4);
        student.setName("Student 4");
        student.setAge(20);
        student.setImage("Student 4".getBytes());
        mStudentDao.insert(student);

        final PrintImpl print = new PrintImpl();
        printStudentList(print);

        student.setAge(21);
        mStudentDao.update(student);

        student = mStudentDao.select(4);
        print.print(student);

        mStudentDao.delete(3);
        printStudentList(print);


        final Student recordProcedure = mStudentTableUtil.getRecordProcedure(1);
        print.print(recordProcedure);

        final String studentName = mStudentTableUtil.getStudentName(2);
        System.out.println(studentName);

        List<Student> students = new ArrayList<>();
        for(int idx = 5; idx <= 10; idx++){
            students.add(new Student("Student " + idx, 20 + idx));
        }

        final int insertStudentCount = mStudentDao.insert(students);
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
                    "\nStudent age : " + student.getAge() +
                    "\nStudent image : " + student.getImage()
            );
        }
    }
}
