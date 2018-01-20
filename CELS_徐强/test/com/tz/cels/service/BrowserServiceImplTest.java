/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.tz.cels.entity.Word;

/**
 * @author 徐强    
 * @create 2017年8月8日上午8:59:30
 */
public class BrowserServiceImplTest {
@Test
		public void getFirstMaptest(){
			BrowserServiceImpl bs=new BrowserServiceImpl();
			Set<Entry<Character,Set<Word>>> s=bs.getFirstMap().entrySet();
			for(Entry<Character,Set<Word>> e:s){
				Character c=e.getKey();
				System.out.println(c+"  ");
				for(Word w:bs.getFirstMap().get(c)){
					System.out.println(w.getWord());
				}
			}
		}
}
