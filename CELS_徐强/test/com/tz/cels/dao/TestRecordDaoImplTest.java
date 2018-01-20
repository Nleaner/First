/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.dao;




import org.junit.Test;

import com.tz.cels.entity.TestRecord;

/**
 * @author 徐强    
 * @create 2017年8月7日上午10:28:41
 */
public class TestRecordDaoImplTest {
/*@Test
   	public void writetest(){
	String path="C:\\Users\\Administrator\\Desktop\\9.txt";
	Date d1=new Date();
	Date d2=new Date();
	Long l1=1L;
	Long l2=2L;
	Long l3=3L;
	Long l4=4L;
	List<String> s=new ArrayList<>();
	TestRecord t=new TestRecord(d1, d2, l1, l2, l3, l4, s);
	List<TestRecord> lt=new ArrayList<>();
	lt.add(t);
	TestRecordDaoImpl tr=new TestRecordDaoImpl();
	tr.write(lt, path);
}*/
@Test
public void readtest(){
	String path="C:\\Users\\Administrator\\Desktop\\9.txt";
	TestRecordDaoImpl tr=new TestRecordDaoImpl();
	for(TestRecord t:tr.read(path)){
		System.out.println(t);
	}
}
}
