package com.example.fantaskbackend;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DBConnectionTest {

    @Test
    public void dbConnectionTest() throws SQLException {
        String user = System.getenv("user");
        String password = System.getenv("password");
        String url = System.getenv("url");

        Connection connection = DriverManager.getConnection(url, user, password);

        assertNotNull(connection);
    }

}
