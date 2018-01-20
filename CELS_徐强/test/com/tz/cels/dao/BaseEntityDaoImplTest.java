/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

/**
 * @author 徐强    
 * @create 2017年8月7日上午10:05:33
 */

public class BaseEntityDaoImplTest {
@Test
		public void TestgetAllwords(){
			BaseEntityDaoImpl b=new BaseEntityDaoImpl();
			for(Word w:b.getAllWords()){
				System.out.println(w);
			}
			System.out.println("-------------------------------");
}
@Test
public void getAllVocabularies(){
	BaseEntityDaoImpl b=new BaseEntityDaoImpl();
	for(Vocabulary v:b.getAllVocabularies()){
		System.out.println(v.toString());
	}
}
@Test
public void writetoFileTest(){
	Map<String, String> map=new HashMap<>();
	String s1="hello";
	String s2="你好";
	map.put(s1, s2);
	String path="data//history//EN_TO_CN_FILE";
	BaseEntityDaoImpl b=new BaseEntityDaoImpl();
	b.writeToFile(map, path);
}
@Test
public void readFromFileTest(){
	String path="data//history//EN_TO_CN_FILE";
	BaseEntityDaoImpl b=new BaseEntityDaoImpl();
	Set<Entry<String, String>> entry=b.readFromFile(path).entrySet();
	for(Entry<String, String> entry1:entry){
		String key=entry1.getKey();
		String value=entry1.getValue();
		System.out.println(key+" "+value);
	}
}
}
