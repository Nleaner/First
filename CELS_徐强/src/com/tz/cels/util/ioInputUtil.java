/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 徐强    
 * @create 2017年8月8日下午5:18:45
 */
public class ioInputUtil {
	public int IntInput(){
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			return Integer.parseInt(br.readLine());
		} 
		catch (Exception e) {
			System.out.println("输入有误，请重新输入");
			return IntInput();
		}
		
	}
	public char CharInput(){
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			return br.readLine().charAt(0);
		} catch (Exception e) {
			System.out.println("输入有误，请重新输入");
			return CharInput();
		}
	}
	public String StringInput(){
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} 
		catch (Exception e) {
			System.out.println("输入有误，请重新输入");
			return StringInput();
		}
	}
}
