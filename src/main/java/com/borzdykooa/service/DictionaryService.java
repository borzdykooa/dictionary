package com.borzdykooa.service;

import com.borzdykooa.dao.DictionaryDao;
import com.borzdykooa.entity.Dictionary;
import com.borzdykooa.util.DaoQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DictionaryService {

    private static final DictionaryService INSTANCE = new DictionaryService();

    public List<Dictionary> getDictionariesByOneQuery() {
        return DictionaryDao.getInstance().getAllDictionaries(DaoQuery.GET_ALL_DICTIONARIES);
    }

    public List<Dictionary> getDictionariesWithJava() {
        List<Dictionary> firstDictionaries = DictionaryDao.getInstance().getAllDictionaries(DaoQuery.GET_FIRST_TABLE_DICTIONARIES);
        List<Dictionary> secondDictionaries = DictionaryDao.getInstance().getAllDictionaries(DaoQuery.GET_SECOND_TABLE_DICTIONARIES);
        TreeSet<Dictionary> dictionaries = new TreeSet<>();
        dictionaries.addAll(firstDictionaries);
        dictionaries.addAll(secondDictionaries);

        return new ArrayList<>(dictionaries);
    }

    public static DictionaryService getInstance() {
        return INSTANCE;
    }
}
