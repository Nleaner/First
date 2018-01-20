package com.tz.cels.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;

public class PageBean {
		private List<Vocabulary> datas;
		private int pageSize;
		private int first;
		private int last;
		private int previous;
		private int next;
		private int current;
		private int pages;
		private int total;
		private String style;
		public PageBean(Set<Vocabulary> datas,int pageSize){
			this.datas=new ArrayList<>();
			for(Vocabulary v:datas){
				this.datas.add(v);
			}
			this.pageSize=pageSize;
			this.first=1;
			this.total=this.datas.size();
			this.pages=this.total % this.pageSize==0?this.total/this.pageSize:this.total/this.pageSize+1;
			this.last=this.pages;
			setCurrent(1);
		}
		public void setCurrent(int current) {
			// TODO Auto-generated method stub
			if(current<=0){
				this.current=1;
			}
			else{
			this.current=current;
			this.next=this.current==this.last?this.current:this.current+1;
			this.previous=this.current==1?1:this.current-1;
			this.style=this.current+" ☠  "+(this.current+1)+" ☠  "+(this.current+2)+"..."+(this.pages);
			}
		}
		/**
		 * @return the datas
		 */
		public List<Vocabulary> getDatas() {
			return datas;
		}
		public List<Vocabulary> getDatas(int page){
			if(page<=0){
				page=1;
			}else if(page>this.pages){
				page=this.pages;
			}
			List<Vocabulary> pageContent=new ArrayList<>();
			for(int i=(page-1)*this.pageSize;i<page*this.pageSize&&i<this.datas.size();i++){
				pageContent.add(this.datas.get(i));
			}
			return pageContent;
		}
		public int getPageSize() {
			return pageSize;
		}
		/**
		 * @return the first
		 */
		public int getFirst() {
			return first;
		}
		/**
		 * @return the last
		 */
		public int getLast() {
			return last;
		}
		/**
		 * @return the previous
		 */
		public int getPrevious() {
			return previous;
		}
		/**
		 * @return the next
		 */
		public int getNext() {
			return next;
		}
		/**
		 * @return the current
		 */
		public int getCurrent() {
			return current;
		}
		/**
		 * @return the pages
		 */
		public int getPages() {
			return pages;
		}
		/**
		 * @return the total
		 */
		public int getTotal() {
			return total;
		}
		/**
		 * @return the style
		 */
		public String getStyle() {
			return style;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("每页");
			builder.append(pageSize+"行");
			builder.append(", 共");
			builder.append(pages+"页");
			builder.append(", 共");
			builder.append(total+"个词");
			builder.append(", ");
			builder.append(style);
			return builder.toString();
		}
		
}
