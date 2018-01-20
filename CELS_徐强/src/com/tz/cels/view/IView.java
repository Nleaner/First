/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.view;

/**
 * @author 徐强    
 * @create 2017年8月4日上午11:28:14
 */
public interface IView {
	void welcome();
	//主页面
	void MainMenu();
	//显示主菜单
	void showBrowserSubMenu();
	//显示一级子菜单
	void showGameSubMenu();
	//显示游戏菜单
	void showTestingSubMenu();
	//显示测试菜单
	void showNewWordSubNenu();
	//显示生词菜单
}
