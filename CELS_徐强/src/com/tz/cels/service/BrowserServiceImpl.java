/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.tz.cels.dao.BaseEntityDaoImpl;
import com.tz.cels.dao.impl.IBaseEntityDao;
import com.tz.cels.entity.Word;
import com.tz.cels.service.impl.IBrowserService;


public class BrowserServiceImpl implements IBrowserService {
	private IBaseEntityDao baseEntityDao=new BaseEntityDaoImpl();
	@Override
	public Map<Character, Set<Word>> getFirstMap() {
		// TODO Auto-generated method stub
		Map<Character,Set<Word>> dates=new TreeMap<>();
		baseEntityDao.getAllWords();
		for(Word w:baseEntityDao.getAllWords()){
			if(dates.containsKey(w.getFirst())){
				dates.get(w.getFirst()).add(w);
			}
			else{
				Set<Word> samefirst=new TreeSet<>();
				samefirst.add(w);
				dates.put(w.getFirst(), samefirst);
			}
		}
		return dates;
	}

	@Override
	public PageBean getPageVocabularies() {
		// TODO Auto-generated method stub
		PageBean pagebean=new PageBean(baseEntityDao.getAllVocabularies(),PAGE_SIZE); 
		return pagebean;
	}
}
