/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.tz.cels.service.impl.IGameService;

/**
 * @author 徐强    
 * @create 2017年8月8日下午2:03:55
 */
public class GameServiceImplTest {
@Test
public void en2cntest(){
	IGameService i=new GameServiceImpl();
	
	Set<Entry<String,String>> s=i.en2cn(false).entrySet();
	for(Entry<String,String> e:s){
		System.out.println(e.getKey());
		System.out.println(e.getValue());
	}
}		
/*@Test
public void cn2entest(){
	IGameService i=new GameServiceImpl();
	Set<Entry<String,String>> s=i.cn2en(true).entrySet();
	for(Entry<String,String> e:s){
		System.out.println(e.getKey());
		System.out.println(e.getValue());
	}
}*/
/*@Test
public void saveGameHistorytest(){
	IGameService i=new GameServiceImpl();
	i.saveGameHistory(i.en2cn(true), true);
}*/
}
