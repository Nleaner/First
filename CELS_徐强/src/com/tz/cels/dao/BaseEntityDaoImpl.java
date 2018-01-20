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
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.tz.cels.dao.impl.IBaseEntityDao;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

/**
 * @author 徐强    
 * @create 2017年8月5日上午10:54:44
 */
public class BaseEntityDaoImpl implements IBaseEntityDao {

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.IBaseEntityDao#getAllWords()
	 */
	@Override
	public Set<Word> getAllWords() {
		// TODO Auto-generated method stub
		Set<Word> words=new TreeSet<>();
		File file=new File(WORD_FILE);
		if(!file.exists()){
			System.out.println("原始单词数据文件不存在");
		}
		else{
			try(BufferedReader bf=new BufferedReader(new FileReader(file))) {
				String line=null;
				Long id=0L;
				while((line=bf.readLine())!=null){
					id++;
					String[] splitline=line.split(" ");
					String danci=splitline[0];
					String[] hanzi=splitline[1].split(":");
					Word word=new Word(id,danci,hanzi);
					words.add(word);
				}
				int id1=1;
				for(Word w:words){
					w.setId(id1);
					id1++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return words;
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.IBaseEntityDao#getAllVocabularies()
	 */
	@Override
	public Set<Vocabulary> getAllVocabularies() {
		// TODO Auto-generated method stub
		Set<Vocabulary> vSet=new TreeSet<>();
		File file_V=new File(VOCABULARY_FILE);
		if(!file_V.exists()){
			System.out.println("原始词汇数据文件不存在");
		}
		else{
			try(BufferedReader bf=new BufferedReader(new FileReader(file_V))) {
				String line=null;
				
				while((line=bf.readLine())!=null){
					
					String[] splitline=line.split("#");
					String danci=splitline[0];
					String[] hanzi=splitline[1].split(":");
					if(splitline.length>2)
					{
					String suoxie=splitline[2];
					Vocabulary v=new Vocabulary(danci,hanzi,suoxie);
					vSet.add(v);         
					}
					else {
						Vocabulary v1=new Vocabulary(danci,hanzi);
						vSet.add(v1);
					}
				}
				int id1=1;
				for(Vocabulary v:vSet){
					v.setId(id1);
					id1++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vSet;
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.IBaseEntityDao#writeToFile(java.util.Map, java.lang.String)
	 */
	@Override
	public void writeToFile(Map<String, String> map, String fileName) {
		// TODO Auto-generated method stub
		File file=new File(fileName);
		if(!file.exists()){
			System.out.println("Map指定文件名不存在");
		}
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.IBaseEntityDao#readFromFile(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> readFromFile(String fileName) {
		// TODO Auto-generated method stub
		File file=new File(fileName);
		if(!file.exists()){
			System.out.println("Map指定文件名不存在");
		}
		try(ObjectInputStream oos=new ObjectInputStream(new FileInputStream(file))) {
			
			Map<String,String> m=(Map<String, String>) oos.readObject();
			//System.out.println(m.size());
			return m;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

}
