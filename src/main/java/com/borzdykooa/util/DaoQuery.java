package com.borzdykooa.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaoQuery {

    public static final String GET_ALL_DICTIONARIES =
            "SELECT " +
                    "  d1.word         AS word, " +
                    "  d1.reference_id AS reference_id " +
                    "FROM dictionary_schema.dictionary_1 d1 " +
                    "UNION " +
                    "SELECT " +
                    "  d2.word         AS word, " +
                    "  d2.reference_id AS reference_id " +
                    "FROM dictionary_schema.dictionary_2 d2 " +
                    "WHERE d2.word NOT IN (SELECT d1.word " +
                    "                      FROM dictionary_schema.dictionary_1 d1) " +
                    "ORDER BY word;";

    public static final String GET_FIRST_TABLE_DICTIONARIES =
            "SELECT " +
                    "  d1.word         AS word, " +
                    "  d1.reference_id AS reference_id " +
                    "FROM dictionary_schema.dictionary_1 d1";

    public static final String GET_SECOND_TABLE_DICTIONARIES =
            "SELECT " +
                    "  d2.word         AS word, " +
                    "  d2.reference_id AS reference_id " +
                    "FROM dictionary_schema.dictionary_2 d2";
}
