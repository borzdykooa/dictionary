package com.borzdykooa.connection;

import com.borzdykooa.util.PropertyManager;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectionProvider {

    public static Connection getConnection() throws SQLException {
        String url = PropertyManager.get("db.url");
        String user = PropertyManager.get("db.user");
        String pass = PropertyManager.get("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
