/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author 徐强    
 * @create 2017年8月4日下午2:19:53
 * 基本实体和实现类
 */
public abstract class BaseEntity implements Serializable,Comparable<BaseEntity> {

	//private static final long serialVersionUID = -3324930428614461097L;

	private static final long serialVersionUID = 1L;
	
	private long id;
	

	private String word;//单词
	
	private String[] chinese;

	public BaseEntity() {
		super();
	}
	public BaseEntity(long id) {
		super();
		this.id = id;
	}
	public BaseEntity(String word) {
		super();
		this.word = word;
	}
	public BaseEntity(String[] chinese) {
		super();
		this.chinese = chinese;
	}

	public BaseEntity(long id, String word, String[] chinese) {
		super();
		this.id = id;
		this.word = word;
		this.chinese = chinese;
	}
	public BaseEntity(long id, String word) {
		super();
		this.id = id;
		this.word = word;
	}

	public BaseEntity(String word, String[] chinese) {
		super();
		this.word = word;
		this.chinese = chinese;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
		
	}

	/**
	 * @return the chineset
	 */
	public String[] getChinese() {
		return chinese;
	}

	/**
	 * @param chinese the chinese to set
	 */
	public void setChinese(String[] chinese) {
		this.chinese = chinese;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=");
		builder.append(id);
		builder.append(", ");
		builder.append(word);
		builder.append(", ");
		builder.append(Arrays.toString(chinese));
		//builder.append(chinese);
		return builder.toString();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(chinese);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (!Arrays.equals(chinese, other.chinese))
			return false;
		if (id != other.id)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	public int compareTo(BaseEntity o) {
		// TODO Auto-generated method stub;
		return this.getWord().compareTo(o.getWord());
	}
}
