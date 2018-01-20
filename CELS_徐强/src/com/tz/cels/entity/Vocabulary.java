/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.entity;

import java.util.Arrays;

/**
 * @author 徐强    
 * @create 2017年8月4日下午2:41:48
 */
public class Vocabulary extends BaseEntity {

	private static final long serialVersionUID = 1L;
    
	private String acronmy;//词汇缩写
	
	public Vocabulary(){
		
	}
	public Vocabulary(String acronym){
		this.acronmy=acronym;
	}
	public Vocabulary(String chinese,String acronym){
		super(chinese);
		this.acronmy=acronym;
	}
	public Vocabulary(long id,String word,String[] chinese,String acronym){
		super(id,word,chinese);
		this.acronmy=acronym;
	}
	public Vocabulary(String word,String[] chinese,String acronym){
		super(word,chinese);
		this.acronmy=acronym;
	}
	public Vocabulary(String word,String[] chinese){
		super(word,chinese);
	}
	public Vocabulary(long id,String word,String[] chinese){
		super(id,word,chinese);
	}
	/**
	 * @return the acronmy
	 */
	public String getAcronmy() {
		return acronmy;
	}
	/**
	 * @param acronmy the acronmy to set
	 */
	public void setAcronmy(String acronmy) {
		this.acronmy = acronmy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=");
		builder.append(getId());
		builder.append(", ");
		builder.append(getWord());
		builder.append(", ");
		builder.append(Arrays.toString(getChinese()));
		if(acronmy!=null)
		{
			builder.append(", ");
		builder.append(acronmy);
		}
		
		return builder.toString();
	}
	
}
