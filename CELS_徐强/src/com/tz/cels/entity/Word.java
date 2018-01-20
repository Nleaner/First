/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.entity;

/**
 * @author 徐强    
 * @create 2017年8月4日下午2:28:06
 */
public class Word extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private char first;
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public Word(){
		
	}
	public Word(long id,String word,String[] chinese ){
		super(id,word,chinese);
		this.first=word.toUpperCase().charAt(0);
	}
	public Word(String word,String[] chinese){
		super(word,chinese);
		this.first=word.toUpperCase().charAt(0);
	}
	public Word(String word){
		super(word);
		this.first=word.toUpperCase().charAt(0);
	}
	public Word(long id,String word){
		super(id,word);
		this.first=word.toUpperCase().charAt(0);
	}
	/**
	 * @return the first
	 */
	public char getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(char first) {
		this.first = first;
	}

}
