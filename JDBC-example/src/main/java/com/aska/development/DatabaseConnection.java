package com.aska.development;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //region Fields

    private static final String DATABASE_URL = "jdbc:mysql://localhost/development?autoReconnect=true&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "admin";

    //endregion

    //region Methods

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(
                DATABASE_URL,
                USER_NAME,
                USER_PASSWORD
        );
    }

    //endregion
}
