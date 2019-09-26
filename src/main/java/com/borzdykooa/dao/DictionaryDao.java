package com.borzdykooa.dao;

import com.borzdykooa.connection.ConnectionProvider;
import com.borzdykooa.entity.Dictionary;
import com.borzdykooa.exception.ApplicationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DictionaryDao {

    private static final DictionaryDao INSTANCE = new DictionaryDao();

    public List<Dictionary> getAllDictionaries(String query) {
        List<Dictionary> dictionaries = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Dictionary dictionary = Dictionary.builder()
                        .word(resultSet.getString("word"))
                        .referenceId(Long.valueOf(resultSet.getString("reference_id")))
                        .build();
                dictionaries.add(dictionary);
            }
        } catch (SQLException e) {
            throw new ApplicationException("SQLException occurred in DictionaryDao:getAllDictionaries");
        }

        return dictionaries;
    }

    public static DictionaryDao getInstance() {
        return INSTANCE;
    }
}
