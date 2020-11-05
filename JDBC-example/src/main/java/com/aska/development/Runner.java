package com.aska.development;

import java.sql.*;
import java.util.Properties;

public class Runner {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static void main(String[] args) {


    }

    private static class StatementSample {
        static void execute() {
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


                String sqlQuery = null;


                statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                );


//                DatabaseMetaData metaData = connection.getMetaData();
//                if (metaData.supportsBatchUpdates()) {
//                    connection.setAutoCommit(false);
//                    sqlQuery = "INSERT INTO developers(name, specialty, salary) VALUES ('Aska1', 'A', 100);";
//                    statement.addBatch(sqlQuery);
//                    sqlQuery = "INSERT INTO developers(name, specialty, salary) VALUES ('Aska2', 'B', 200);";
//                    statement.addBatch(sqlQuery);
//                    sqlQuery = "INSERT INTO developers(name, specialty, salary) VALUES ('Aska3', 'C', 300);";
//                    statement.addBatch(sqlQuery);
//                    statement.executeBatch();
//                    connection.commit();
//                }

                DatabaseMetaData metaData = connection.getMetaData();
                if (metaData.supportsBatchUpdates()) {
                    connection.setAutoCommit(false);
                    sqlQuery = "INSERT INTO developers(name, specialty, salary) VALUES (?, ?, ?);";

                    preparedStatement = connection.prepareStatement(sqlQuery);

                    preparedStatement.setString(1, "Aska1");
                    preparedStatement.setString(2, "A");
                    preparedStatement.setInt(3, 100);
                    preparedStatement.addBatch();

                    preparedStatement.setString(1, "Aska2");
                    preparedStatement.setString(2, "B");
                    preparedStatement.setInt(3, 200);
                    preparedStatement.addBatch();

                    preparedStatement.setString(1, "Aska3");
                    preparedStatement.setString(2, "C");
                    preparedStatement.setInt(3, 300);
                    preparedStatement.addBatch();

                    preparedStatement.executeBatch();
                    connection.commit();
                }


                int insertItemCount = preparedStatement.executeUpdate();
                if (insertItemCount == 1) {
                    System.out.println("Inserted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (statement != null && !statement.isClosed()) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (connection != null && !connection.isClosed()) {
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

        public static final String DATABASE_URL = "jdbc:mysql://localhost/library?autoReconnect=true&useSSL=false&user=root&password=admin";

        public static void createDatabase() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "CREATE DATABASE development";
                int executeUpdate = statement.executeUpdate(sqlQuery);

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

        public static void dropDatabase() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "DROP DATABASE exampleDB";
                int executeUpdate = statement.executeUpdate(sqlQuery);

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

        public static void createTable() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "CREATE TABLE Language" +
                        "(" +
                            "id INTEGER NOT NULL," +
                            "name VARCHAR(50)," +
                            "author_name VARCHAR(50)," +
                            "PRIMARY KEY (id)" +
                        ")";
                int executeUpdate = statement.executeUpdate(sqlQuery);
                System.out.println(executeUpdate);
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

        public static void dropTable() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "DROP TABLE language";
                int executeUpdate = statement.executeUpdate(sqlQuery);
                System.out.println(executeUpdate);
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

        public static void insert() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "INSERT INTO language VALUES (1 , 'Java', 'Bla-bla')";
                int executeUpdate = statement.executeUpdate(sqlQuery);
                System.out.println(executeUpdate);
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

        public static void select() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();
                String sqlQuery = "SELECT id, name, author_name FROM language";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()){
                    System.out.println("Id : " + resultSet.getInt("id"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("Author : " + resultSet.getString("author_name"));
                }
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

        public static void update() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();

                String updateSqlQuery = "UPDATE language SET author_name = 'Gosling' WHERE id = 1";
                statement.executeUpdate(updateSqlQuery);

                String getSqlQuery = "SELECT id, name, author_name FROM language";
                ResultSet resultSet = statement.executeQuery(getSqlQuery);
                while (resultSet.next()){
                    System.out.println("Id : " + resultSet.getInt("id"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("Author : " + resultSet.getString("author_name"));
                }

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

        public static void delete() {
            Connection connection = null;
            try {

                String databaseUrl = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false&user=root&password=admin";
                connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement();

                String deleteSqlQuery = "DELETE FROM language WHERE id = 1";
                statement.executeUpdate(deleteSqlQuery);

                String getSqlQuery = "SELECT id, name, author_name FROM language";
                ResultSet resultSet = statement.executeQuery(getSqlQuery);
                while (resultSet.next()){
                    System.out.println("Id : " + resultSet.getInt("id"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("Author : " + resultSet.getString("author_name"));
                }

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

        public static void execute() {

            System.out.println("Registering JDBC driver...");
            try {
                Class.forName(JDBC_DRIVER);


                System.out.println("Creating database connection...");
                Properties properties = new Properties();
                properties.setProperty("user", "root");
                properties.setProperty("password", "admin");
                properties.setProperty("useSSL", "false");
                Connection connection = DriverManager.getConnection(Runner.DATABASE_URL, properties);

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
