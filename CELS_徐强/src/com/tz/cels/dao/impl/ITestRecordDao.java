/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.dao.impl;

import java.util.List;

import com.tz.cels.entity.TestRecord;

/**
 * @author 徐强    
 * @create 2017年8月5日上午10:38:39
 */
public interface ITestRecordDao {
		void write(List<TestRecord> records, String fileName);
		List<TestRecord> read(String fileName);
}
