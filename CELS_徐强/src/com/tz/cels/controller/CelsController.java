/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.controller;

import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tz.cels.controller.impl.Controller;
import com.tz.cels.dao.BaseEntityDaoImpl;
import com.tz.cels.entity.BaseEntity;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.service.BrowserServiceImpl;
import com.tz.cels.service.GameServiceImpl;
import com.tz.cels.service.PageBean;
import com.tz.cels.service.TestingServiceImpl;
import com.tz.cels.service.impl.IBrowserService;
import com.tz.cels.service.impl.IGameService;
import com.tz.cels.service.impl.ITestingService;
import com.tz.cels.util.ioInputUtil;
import com.tz.cels.view.impl.CommandView;

/**
 * @author 徐强    
 * @create 2017年8月8日下午4:53:39
 */
public class CelsController implements Controller{
		private CommandView view=new CommandView();
		private IBrowserService browserService;
		private IGameService gameService;
		private ITestingService testingService;
		private ioInputUtil io=new ioInputUtil();
	@Override
	public void action() {
		// TODO Auto-generated method stub
		view.welcome();
		view.MainMenu();
		System.out.println("请输入相应数字：");
		int maincase;
		do{
			maincase=io.IntInput();
		switch (maincase) {
case 1:
			view.showBrowserSubMenu();
			browserService=new BrowserServiceImpl();
			int Browcase;
			do{
				Browcase=io.IntInput();
			
			switch (Browcase) {
			case 1:
				Set<Entry<Character,Set<Word>>> s=browserService.getFirstMap().entrySet();
				for(Entry<Character,Set<Word>> e:s){
					Character c=e.getKey();
					System.out.print(c+"["+browserService.getFirstMap().get(c).size()+"] ");					
				}
				System.out.println();
				System.out.println("请输入相应字符进行浏览：");
				char u=io.CharInput();
				if(u>=97)
					u-=32;
				int count=0;
				for(Word w:browserService.getFirstMap().get(u)){
					count++;
					System.out.printf("%s",w);
					if(count%15==0){
						System.out.println("输入0退出，输入其他数字继续查看下一页");
						int n=io.IntInput();
						if(n==0){
							break ;
						}
						
					}
					
				}
				view.showBrowserSubMenu();
				break;
			case 2:
				System.out.println("每页有"+browserService.PAGE_SIZE+"行"+" "+"一共"+browserService.getPageVocabularies().getPages()+"页");
				System.out.println("一共"+browserService.getPageVocabularies().getDatas().size()+"词");
				System.out.println("请输入要浏览的页数");
				while(true){
					int yeshu=io.IntInput();
				if(yeshu<0||yeshu>browserService.getPageVocabularies().getPages()){
					System.out.println("输入有误");
				}
				 PageBean p=browserService.getPageVocabularies();
				 p.setCurrent(yeshu);
				 List<Vocabulary> list=p.getDatas(yeshu);
				 for(Vocabulary v:list){
					 System.out.println(v);
				 }
				 System.out.println(p);
				 System.out.println("请输入要浏览的页数：");
				 System.out.println("退出请按0");
				 if(yeshu==0)
					 break;
				}
				view.showBrowserSubMenu();
				break;
			case 0:
				System.out.println("返回成功！");
				break;
			default:
				System.out.println("输入有误！请重新输入：");
				view.showBrowserSubMenu();
				break;
			}
			}while(Browcase!=0);
			view.MainMenu();
			break;
			
case 2:
	view.showGameSubMenu();
	gameService=new GameServiceImpl();
	int gamecase;
	do{
		gamecase=io.IntInput();
		switch (gamecase) {
		case 1:
			System.out.println("是否要从上一次继续？Y/N");
			char YN=io.CharInput();
			if(YN=='Y'||YN=='y'){
				Set<Entry<String, String>> s=gameService.en2cn(false).entrySet();
				Map<String,String> map=new TreeMap<String, String>();
				int count1=0;
				//System.out.println(map.size());
				for(Entry<String,String> e:s){
					System.out.println("提示："+e.getKey());
					System.out.println(e.getValue());
					System.out.println("请输入中文：");
					System.out.println("退出请按回车！");
					String shuru=io.StringInput();
					count1++;
					if(shuru.equals(e.getValue())){
						System.out.println("回答正确！");
						
					}
					else if(shuru.length()==0){
						map.put(e.getKey(), e.getValue());
						int count2=0;
						for(Entry<String,String> e1:s){
							count2++;
							if(count1==count2){
								gameService.saveGameHistory(map, true);
								count1++;
							}
						}
						
						break;
					}
					else{
						System.out.println("回答错误！");
						gameService.saveGameHistory(map, true);
						System.out.println("正确答案为："+e.getValue());
					}
				}
			}
			else if(YN=='N'||YN=='n'){
				Set<Entry<String, String>> s=gameService.en2cn(true).entrySet();
				Map<String,String> map=new TreeMap<String, String>();
				for(Entry<String,String> e:s){
					int count1=0;
					System.out.println("提示："+e.getKey());
					System.out.println(e.getValue());
					System.out.println("请输入中文：");
					System.out.println("退出请按回车！");
					String shuru=io.StringInput();
					count1++;
					if(shuru.equals(e.getValue())){
						System.out.println("回答正确！");
						
					}
					else if(shuru.length()==0){
						map.put(e.getKey(), e.getValue());
						int count2=0;
						for(Entry<String,String> e1:s){
							count2++;
							if(count1==count2){
								gameService.saveGameHistory(map, true);
								count1++;
							}
						}
						break;
					}
					else{
						System.out.println("回答错误！");
						System.out.println("正确答案为："+e.getValue());
						gameService.saveGameHistory(map, true);
					}
				}
				
			}
			view.showGameSubMenu();
			break;
		case 2:
			System.out.println("是否要从上一次继续？Y/N");
			char YN1=io.CharInput();
			if(YN1=='Y'||YN1=='y'){
				Set<Entry<String, String>> s=gameService.cn2en(false).entrySet();
				Map<String,String> map=new TreeMap<String, String>();
				for(Entry<String,String> e:s){
					int count1=0;
					System.out.println("提示："+e.getKey());
					System.out.println(e.getValue());
					System.out.println("请输入英文：");
					System.out.println("退出请按回车！");
					String shuru=io.StringInput();
					count1++;
					if(shuru.equals(e.getValue())){
						System.out.println("回答正确！");
						
					}
					else if(shuru.length()==0){
						map.put(e.getKey(), e.getValue());
						int count2=0;
						for(Entry<String,String> e1:s){
							count2++;
							if(count1==count2){
								gameService.saveGameHistory(map, false);
								count1++;
							}
						
						}break;
					}
					else{
						System.out.println("回答错误！");
						gameService.saveGameHistory(map, false);
						System.out.println("正确答案为："+e.getValue());
					}
				}
				
			}
			else if(YN1=='N'||YN1=='n'){
				Set<Entry<String, String>> s=gameService.cn2en(true).entrySet();
				Map<String,String> map=new TreeMap<String, String>();
				for(Entry<String,String> e:s){
					int count1=0;
					if(!e.getKey().isEmpty()){
					System.out.println("提示："+e.getKey());
					System.out.println(e.getValue());
					System.out.println("请输入英文：");
					System.out.println("退出请按回车！");
					String shuru=io.StringInput();
					count1++;
					if(shuru.equals(e.getValue())){
						System.out.println("回答正确！");
						
					}
					else if(shuru.length()==0){
						map.put(e.getKey(), e.getValue());
						int count2=0;
						for(Entry<String,String> e1:s){
							count2++;
							if(count1==count2){
								gameService.saveGameHistory(map, false);
								count1++;
							}
						
						}break;
					}
					else{
						System.out.println("回答错误！");
						System.out.println("正确答案为："+e.getValue());
						gameService.saveGameHistory(map, false);
					}
				
				}
					}
			}
			view.showGameSubMenu();
			break;
		case 0:
			System.out.println("返回成功！");
			break;
		default:
			System.out.println("输入有误！");
			view.showGameSubMenu();
			break;
		   }
	        }while(gamecase!=0);
	        view.MainMenu();
              break;
case 3:
			view.showTestingSubMenu();
			testingService=new TestingServiceImpl();
			int tc=0;
			do {
				tc=io.IntInput();
				switch (tc) {
				case 1:
					System.out.println("请输入测试题目数量：");
					int num=io.IntInput();
					Date date=new Date();
					Date date1=new Date();
					
					Long problemsum=(long) num;
					Long completesum=0L;
					Long truesum=0L;
					Long falsesum=0L;
					List<String> testdata=new ArrayList<>();
					//Long time1=System.currentTimeMillis();
					
					for(BaseEntity b:testingService.getTestingData(num)){
						testdata.add(b.getWord());
						for(int i=0;i<b.getChinese().length;i++)
						System.out.print(b.getChinese()[i]);
						System.out.println();
						System.out.println("请输入英文：");
						System.out.println("退出请按回车！");
						String y=io.StringInput();
						if(b.getWord().equals(y)){
							System.out.println("回答正确！");
							truesum++;
							completesum++;
						}
						else if(y.length()==0){
							System.out.println("退出成功！");
							Date date2=new Date();
							double time=(date2.getTime()-date1.getTime())/1000;
							//long time=System.currentTimeMillis()-time1;
							TestRecord t1=new TestRecord(date, time, problemsum, completesum, truesum, falsesum, testdata);
							System.out.println(t1);
							break;
						}
						else{
							System.out.println("回答错误！");
							System.out.println("正确答案为："+b.getWord());
							falsesum++;
							completesum++;
						}
					
					Date date2=new Date();
					double time=(date2.getTime()-date1.getTime())/1000;
					//long time=System.currentTimeMillis()-time1;
					TestRecord t=new TestRecord(date1, time, problemsum, completesum, truesum, falsesum, testdata);
					System.out.println(t);
					testingService.saveTestRecord(t);
				}
					view.showTestingSubMenu();
					break;
				case 2:
					for(TestRecord tr:testingService.reviewTestRecord()){
						System.out.println(tr);
					}
					view.showTestingSubMenu();
					break;
				case 0:
					System.out.println("返回成功！");
					break;
				default:
					System.out.println("输入有误！请重新输入：");
					view.showTestingSubMenu();
					break;
				}
			} while (tc!=0);
			view.MainMenu();
                   break;
		default:
			System.out.println("退出成功！");
			break;
		}
	}while(maincase!=0);
	}
		public static void main(String[] args) {
			Controller c=new CelsController();
			c.action();
		}
}
