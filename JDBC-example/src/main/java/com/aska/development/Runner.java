package com.aska.development;

import java.sql.*;
import java.util.Properties;

public class Runner {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static void main(String[] args) {
        ConnectionSample.execute();
        StatementSample.execute();

    }

    private static class StatementSample{
        static void execute(){
            String databaseUrl = "jdbc:mysql://localhost/library?autoReconnect=true&useSSL=false";
            String userName = "root";
            String userPassword = "admin";

            Connection connection = null;
            Statement statement = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = DriverManager.getConnection(
                        databaseUrl,
                        userName,
                        userPassword
                );


                String getAllSqlQuery = "SELECT * FROM developers";
                statement = connection.createStatement();
                if(statement.execute(getAllSqlQuery)){
                    ResultSet resultSet = statement.executeQuery(getAllSqlQuery);
                }


                String insertNewItemSqlQuery ="INSERT INTO developers(name, specialty, salary) VALUES (?, ?, ?);";
                preparedStatement = connection.prepareStatement(insertNewItemSqlQuery);
                preparedStatement.setString(1, "June");
                preparedStatement.setString(2, "Java");
                preparedStatement.setInt(3, 1000);

                int insertItemCount = preparedStatement.executeUpdate();
                if(insertItemCount == 1){
                    System.out.println("Inserted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

                try {
                    if(statement != null && !statement.isClosed()){
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if(preparedStatement != null && !preparedStatement.isClosed()){
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if(connection != null && !connection.isClosed()){
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private static class ConnectionSample {
        static void execute() {
            sample_1();
            sample_2();
            sample_3();
        }

        private static void sample_1() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/library?autoReconnect=true&useSSL=false";
                String userName = "root";
                String userPassword = "admin";

                connection = DriverManager.getConnection(
                        databaseUrl,
                        userName,
                        userPassword
                );
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static void sample_2() {
            Connection connection = null;
            try {

//                String databaseUrl = "jdbc:mysql://localhost/library?autoReconnect=true&useSSL=false&user=root&password=admin";
//                String databaseUrl = "jdbc:mysql://address=(host=localhost)(user=root)(password=admin)(autoReconnect=true)(useSSL=false)/library";
                String databaseUrl = "jdbc:mysql://[(host=localhost, user=root,password=admin, autoReconnect=true,useSSL=false)]/library";
                connection = DriverManager.getConnection(databaseUrl);
                System.out.println(connection.isClosed());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static void sample_3() {
            Connection connection = null;
            try {
                Properties properties = new Properties();
                properties.setProperty("user", "root");
                properties.setProperty("password", "admin");
                properties.setProperty("useSSL", "false");
                properties.setProperty("autoReconnect", "true");
                String databaseUrl = "jdbc:mysql://localhost/library";
                connection = DriverManager.getConnection(databaseUrl, properties);
                System.out.println(connection.isClosed());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class BasicSample {

        public static void execute() {

            System.out.println("Registering JDBC driver...");
            try {
                Class.forName(JDBC_DRIVER);


                System.out.println("Creating database connection...");
                Properties properties = new Properties();
                properties.setProperty("user", "root");
                properties.setProperty("password", "admin");
                properties.setProperty("useSSL", "false");
                Connection connection = DriverManager.getConnection(DATABASE_URL, properties);

                System.out.println("Executing statement...");
                Statement statement = connection.createStatement();
                String sqlQuery = "SELECT * FROM developers ";
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                System.out.println("Retrieving data from database...");
                System.out.println("\nDevelopers:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String specialty = resultSet.getString("specialty");
                    int salary = resultSet.getInt("salary");

                    System.out.println("\n================\n");
                    System.out.println("id: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Specialty: " + specialty);
                    System.out.println("Salary: $" + salary);
                }

                System.out.println("Closing connection and releasing resources...");
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

    }
}
