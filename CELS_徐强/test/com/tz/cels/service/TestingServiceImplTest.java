/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tz.cels.entity.BaseEntity;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.service.impl.ITestingService;

/**
 * @author 徐强    
 * @create 2017年8月8日下午3:36:15
 */
public class TestingServiceImplTest {
	ITestingService tts=new TestingServiceImpl();
/*@Test
   public void getTestingDatatest(){
		int sum=2;
		for(BaseEntity b:tts.getTestingData(sum)){
			System.out.println(b);
		}
}*/
@Test
public void reviewTestRecord(){
		
		for(TestRecord t:tts.reviewTestRecord()){
			System.out.println(t);
		}
}
/*@Test
public void saveTestRecord(){
	Date d11=new Date();
	Date d21=new Date();
	Long l11=1L;
	Long l21=2L;
	Long l31=3L;
	Long l41=4L;
	List<String> s1=new ArrayList<>();
	TestRecord t1=new TestRecord(d11, d21, l11, l21, l31, l41, s1);
	Date d1=new Date();
	Date d2=new Date();
	Long l1=1L;
	Long l2=2L;
	Long l3=3L;
	Long l4=4L;
	List<String> s=new ArrayList<>();
	TestRecord t=new TestRecord(d1, d2, l1, l2, l3, l4, s);
	tts.saveTestRecord(t);
	tts.saveTestRecord(t1);
}*/
}
