/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service.impl;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.BaseEntity;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.service.PageBean;

/**
 * @author 徐强    
 * @create 2017年8月6日下午2:20:48
 */
public interface IBrowserService {
		int PAGE_SIZE=15;
		Map<Character, Set<Word>> getFirstMap();
		PageBean getPageVocabularies();
}
