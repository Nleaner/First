/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.tz.cels.dao.BaseEntityDaoImpl;
import com.tz.cels.dao.impl.IBaseEntityDao;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoHistoryException;
import com.tz.cels.service.impl.IGameService;

/**
 * @author 徐强    
 * @create 2017年8月7日下午4:36:48
 */
public class GameServiceImpl implements IGameService{

	@Override
	public Map<String, String> en2cn(boolean isNew) {
		// TODO Auto-generated method stub
		Map<String,String> map=new TreeMap<>();
		if(isNew==true){
		 IBaseEntityDao baseEntityDao=new BaseEntityDaoImpl();
		 Set<Word> sw=baseEntityDao.getAllWords();
		 for(Word w:sw){
			 for(int i=0;i<w.getChinese().length;i++){
				 map.put(w.getWord(), w.getChinese()[i]);
			 }
		 }
		 Set<Vocabulary> sv=baseEntityDao.getAllVocabularies();
		 for(Vocabulary w:sv){
			 for(int i=0;i<w.getChinese().length;i++){
			map.put(w.getWord(), w.getChinese()[i]);	 
			 }
		 }
	}else{
		String path="data//history//EN_TO_CN_FILE";
		File file=new File(path);
		if(!file.exists()){
			try {
				throw new NoHistoryException();
			} catch (NoHistoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			IBaseEntityDao bed=new BaseEntityDaoImpl();
			map=bed.readFromFile(path);
		}
	}
		return map;
	}

	@Override
	public Map<String, String> cn2en(boolean isNew) {
		// TODO Auto-generated method stub
		Map<String,String> map=new TreeMap<>();
		if(isNew==true){
		 IBaseEntityDao baseEntityDao=new BaseEntityDaoImpl();
		 Set<Word> sw=baseEntityDao.getAllWords();
		 for(Word w:sw){
			 for(int i=0;i<w.getChinese().length;i++){
				 map.put(w.getChinese()[i], w.getWord());
			 }
		 }
		 Set<Vocabulary> sv=baseEntityDao.getAllVocabularies();
		 for(Vocabulary w:sv){
			 for(int i=0;i<w.getChinese().length;i++){
				 map.put(w.getChinese()[i], w.getWord());
			 }
		 }
		}
		else{
			String path="data//history//CN_TO_EN_FILE";
			File file=new File(path);
			if(!file.exists()){
				try {
					throw new NoHistoryException();
				} catch (NoHistoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				IBaseEntityDao bed=new BaseEntityDaoImpl();
				bed.readFromFile(path);
			}
		}
		return map;
	}

	@Override
	public void saveGameHistory(Map<String, String> map, boolean en2cn) {
		// TODO Auto-generated method stub
		String path="data//history";
		File file=new File(path);
		IBaseEntityDao bed=new BaseEntityDaoImpl();
		if(!file.exists()){
			file.mkdirs();
		}
		if(en2cn==true){
			String path1="data//history//EN_TO_CN_FILE";
			File file1=new File(path1);
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bed.writeToFile(map, path1);
			//System.out.println("记录保存成功");
		}
		else{
			String path2="data//history//CN_TO_EN_FILE";
			File file2=new File(path2);
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bed.writeToFile(map, path2);
			//System.out.println("记录保存成功");
		}
	}

}
