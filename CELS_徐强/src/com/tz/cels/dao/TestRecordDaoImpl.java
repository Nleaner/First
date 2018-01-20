/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.tz.cels.dao.impl.ITestRecordDao;
import com.tz.cels.entity.TestRecord;

/**
 * @author 徐强    
 * @create 2017年8月5日下午1:29:06
 */
public class TestRecordDaoImpl implements ITestRecordDao {

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.ITestRecordDao#write(java.util.List, java.lang.String)
	 */
	@Override
	public void write(List<TestRecord> records, String fileName) {
		// TODO Auto-generated method stub
			File file=new File(fileName);
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName,true)))) {
				oos.writeObject(records);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.dao.ITestRecordDao#read(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TestRecord> read(String fileName) {
		// TODO Auto-generated method stub
		try(ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {			
			return (List<TestRecord>) ois.readObject();
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
