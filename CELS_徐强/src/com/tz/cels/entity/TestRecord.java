/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 徐强    
 * @create 2017年8月4日下午3:18:36
 */
public class TestRecord implements Serializable,Comparable<TestRecord>{
	private static final long serialVersionUID = 1L;
	private Date date;
	//测试时间
	private double time;
	//测试时长
	private long problemsum;
	//测试总题数
	private long completesum;
	//完成题数
	private long truesum=0;
	//正确个数
	private long falsesum;
	//错误个数
	List<String> testdata;
	//测试数据总和
	public TestRecord(Date date, double time, long problemsum, long completesum, long truesum, long falsesum,
			List<String> testdata) {
		super();
		this.date = date;
		this.time = time;
		this.problemsum = problemsum;
		this.completesum = completesum;
		this.truesum = truesum;
		this.falsesum = falsesum;
		this.testdata = testdata;
	}
	
	public TestRecord() {
		super();
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * @return the problemsum
	 */
	public long getProblemsum() {
		return problemsum;
	}
	/**
	 * @param problemsum the problemsum to set
	 */
	public void setProblemsum(long problemsum) {
		this.problemsum = problemsum;
	}
	/**
	 * @return the completesum
	 */
	public long getCompletesum() {
		return completesum;
	}
	/**
	 * @param completesum the completesum to set
	 */
	public void setCompletesum(long completesum) {
		this.completesum = completesum;
	}
	/**
	 * @return the truesum
	 */
	public long getTruesum() {
		return truesum;
	}
	/**
	 * @param truesum the truesum to set
	 */
	public void setTruesum(long truesum) {
		this.truesum = truesum;
	}
	/**
	 * @return the falsesum
	 */
	public long getFalsesum() {
		return falsesum;
	}
	/**
	 * @param falsesum the falsesum to set
	 */
	public void setFalsesum(long falsesum) {
		this.falsesum = falsesum;
	}
	/**
	 * @return the testdata
	 */
	public List<String> getTestdata() {
		return testdata;
	}
	/**
	 * @param testdata the testdata to set
	 */
	public void setTestdata(List<String> testdata) {
		this.testdata = testdata;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("☞ 测试时间：");
		builder.append(date);
		builder.append(", 测试时长：");
		builder.append(time+"s");
		builder.append(", 题目总数：");
		builder.append(problemsum);
		builder.append(", 完成题目数：");
		builder.append(completesum);
		builder.append(", 正确个数：");
		builder.append(truesum);
		builder.append(", 错误个数：");
		builder.append(falsesum);
		builder.append(", 测试题：");
		builder.append(testdata);
		builder.append(" ☜");
		return builder.toString();
	}
	@Override
	public int compareTo(TestRecord o) {
		// TODO Auto-generated method stub
		if(this.date.before(o.getDate())){
			return 0;
		}
		return 1;
	}
	
}
