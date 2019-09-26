package com.borzdykooa.util;

import com.borzdykooa.exception.ApplicationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadApplicationProperties();
    }

    private static void loadApplicationProperties() {
        try {
            PROPERTIES.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new ApplicationException("IOException occurred in PropertyManager:loadApplicationProperties");
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
