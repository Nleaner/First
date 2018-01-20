package com.tz.cels.dao.impl;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public interface IBaseEntityDao {
		String WORD_FILE="data//dic//ce-word.dic";
		String VOCABULARY_FILE="data//dic//ce-vocabulary.dic";
		Set<Word> getAllWords();
		Set<Vocabulary> getAllVocabularies();
		void writeToFile(Map<String,String>map,String fileName);
		Map<String,String> readFromFile(String fileName);
}
