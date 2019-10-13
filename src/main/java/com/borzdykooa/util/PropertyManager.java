package com.borzdykooa.util;

import com.borzdykooa.exception.ApplicationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadApplicationProperties();
    }

    private static void loadApplicationProperties() {
        try (InputStream resourceAsStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new ApplicationException("IOException occurred in PropertyManager:loadApplicationProperties");
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
