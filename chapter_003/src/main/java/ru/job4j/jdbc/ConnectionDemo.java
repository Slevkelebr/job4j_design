package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        List<String> values = loadDB();
        String url = values.get(0);
        String login = values.get(1);
        String password = values.get(2);
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    public static List<String> loadDB() {
       List<String> values = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(
                Objects.requireNonNull(ConnectionDemo.class.getClassLoader().getResource("app.properties")).getFile()))) {
            read.lines()
                    .filter(i -> !(i.isEmpty() || i.startsWith("#")))
                    .forEach(i -> {
                        if (i.contains("=")) {
                            String[] split = i.split("=");
                            values.add(split[1]);

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();

        }
        return values;
    }
}