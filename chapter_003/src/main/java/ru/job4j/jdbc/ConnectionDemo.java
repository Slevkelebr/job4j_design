package ru.job4j.jdbc;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(
                        getTableScheme(connection, "demo_table")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("c:\\projects\\job4j_design\\chapter_003\\src\\main\\resources\\app.properties");
        properties.load(in);
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, login, password);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }
}