package com.aska.development;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example_1 {
    public static void main(String[] args) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM language")
        ) {
            while (resultSet.next()){
                System.out.println("Id : " + resultSet.getInt("id"));
                System.out.println("Name : " + resultSet.getString("name"));
                System.out.println("Author : " + resultSet.getString("author_name"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
