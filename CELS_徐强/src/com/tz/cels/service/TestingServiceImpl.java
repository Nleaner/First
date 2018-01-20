/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tz.cels.dao.BaseEntityDaoImpl;
import com.tz.cels.dao.TestRecordDaoImpl;
import com.tz.cels.dao.impl.IBaseEntityDao;
import com.tz.cels.dao.impl.ITestRecordDao;
import com.tz.cels.entity.BaseEntity;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.impl.ITestingService;

/**
 * @author 徐强    
 * @create 2017年8月7日下午4:37:21
 */
public class TestingServiceImpl implements ITestingService{
		private ITestRecordDao testRecordDao=new TestRecordDaoImpl();
		private IBaseEntityDao baseEntity=new BaseEntityDaoImpl();
	@Override
	public List<BaseEntity> getTestingData(int num) {
		// TODO Auto-generated method stub
		List<BaseEntity> b=new ArrayList<>();
		for(Word w:baseEntity.getAllWords()){
			b.add(w);
		}
		for(Vocabulary v:baseEntity.getAllVocabularies()){
			b.add(v);
		}
		Collections.shuffle(b);
		List<BaseEntity> result=new ArrayList<>();
		int count=0;
		for(BaseEntity e:b){
			result.add(e);
			count++;
			if(count==num)
				break;
		}
		return result;
	}

	@Override
	public List<TestRecord> reviewTestRecord() {
		// TODO Auto-generated method stub
		String path1="data//testRecord//test";
		File file1=new File(path1);
		if(!file1.exists()){
			try {
				throw new NoTestRecordException();
			} catch (NoTestRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			return testRecordDao.read(path1);
		}
		return null;
	}

	@Override
	public void saveTestRecord(TestRecord record) {
		// TODO Auto-generated method stub
		List<TestRecord> newRecords=new ArrayList<>();
		String path1="data//testRecord//test";
		File file1=new File(path1);
		if(!file1.exists()){
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(file1.length()!=0){
			newRecords=testRecordDao.read(path1);
			newRecords.add(record);
			/*Collections.sort(newRecords, new Comparator<TestRecord>() {
				public int compare(TestRecord t1,TestRecord t2){
				return t2.getDate().compareTo(t1.getDate());
				}
			});*/
			Collections.sort(newRecords);
		}
		else{
			newRecords.add(record);
		}
		testRecordDao.write(newRecords, path1);
		System.out.println("测试记录保存成功...");
	}

}
