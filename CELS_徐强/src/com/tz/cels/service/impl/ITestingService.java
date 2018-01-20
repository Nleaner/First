/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service.impl;

import java.util.List;

import com.tz.cels.entity.BaseEntity;
import com.tz.cels.entity.TestRecord;

/**
 * @author 徐强    
 * @create 2017年8月6日下午2:21:50
 */
public interface ITestingService {
		String TESTRECORD_DIR="data//testing";
		String TEST_RECORD_FILE="records.rec";
		List<BaseEntity> getTestingData(int num);
		List<TestRecord> reviewTestRecord();
		void saveTestRecord(TestRecord record);
}
