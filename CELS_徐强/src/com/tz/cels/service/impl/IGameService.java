/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.service.impl;

import java.util.Map;

/**
 * @author 徐强    
 * @create 2017年8月6日下午2:21:15
 */
public interface IGameService {
	String HISTORY_DIR="data//history";
	String En_TO_CN_FILE="data//history//en2cn.his";
	String CN_TO_EN_FILE="data//history//cn2en.his";
	Map<String, String> en2cn(boolean isNew);
	Map<String, String> cn2en(boolean isNew);
	void saveGameHistory(Map<String,String> map,boolean en2cn); 
	
}
