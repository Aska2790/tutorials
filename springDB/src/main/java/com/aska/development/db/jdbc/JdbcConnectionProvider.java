package com.aska.development.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionProvider implements ConnectionProvider {
    //region Fields

    private static final String DATABASE_URL = "jdbc:sqlite:database/SpringDB.db";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    //endregion

    //region Constructors

    public JdbcConnectionProvider() {

    }

    //endregion

    //region Methods

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE_URL,
                USER_NAME,
                PASSWORD);
    }

    //endregion
}
