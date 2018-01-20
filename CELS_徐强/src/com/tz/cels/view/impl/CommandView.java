/**
 * 归  于  X 专 属，Studying......
 */
package com.tz.cels.view.impl;

import com.tz.cels.view.IView;

/**
 * @author 徐强    
 * @create 2017年8月4日上午11:31:23
 */
public class CommandView implements IView {

	/* (non-Javadoc)
	 * @see com.tz.cels.view.IView#welcome()
	 */
	@Override
	public void welcome() {
		// TODO Auto-generated method stub
			System.out.println("--------------------------------------");
			System.out.println("              项目代号：CELS             ");
			System.out.println("--Computer English Learning Software--");
			System.out.println("版本号：V0.1                            ");
			System.out.println("作者：徐强                                                                             ");
			System.out.println("产品相关描述：                                                                      ");
			System.out.println("本软件可以用于学习计算机英语单词和词汇，可以游戏方式");
			System.out.println("进行学习，可以进行自我测试。基于JavaSE实现，功能有");
			System.out.println("限，略显lowbi，产品不做任何商业用途，欢迎交流使用！");
			System.out.println("Mailto：www.532749213@qq.com            ");
			System.out.println("有任何问题，自行解决，请勿打扰！！！");
			System.out.println("----------------------------------------");
	}
	@Override
	public void MainMenu() {
		// TODO Auto-generated method stub
		System.out.println("---------------");
		System.out.println("-> 1.浏览单词和词汇");
		System.out.println("-> 2.做游戏，学单词");
		System.out.println("-> 3.自我测试");
		System.out.println("-> 0.退出");
		System.out.println("---------------");
	}
	/* (non-Javadoc)
	 * @see com.tz.cels.view.IView#showBrowserSubMenu()
	 */
	@Override
	public void showBrowserSubMenu() {
		// TODO Auto-generated method stub
			System.out.println("---------------");
			System.out.println("-> 1.浏览单词");
			System.out.println("-> 2.浏览词汇");
			System.out.println("-> 0.返回上一级");
			System.out.println("---------------");
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.view.IView#showGameSubMenu()
	 */
	@Override
	public void showGameSubMenu() {
		// TODO Auto-generated method stub
			System.out.println("----------------");
			System.out.println("-> 1.提示英文，回答中文");
			System.out.println("-> 2.提示中文，回答英文");
			System.out.println("-> 0.返回上一级");
			System.out.println("----------------");
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.view.IView#showTestingSubMenu()
	 */
	@Override
	public void showTestingSubMenu() {
		// TODO Auto-generated method stub
		System.out.println("--------------------");
		System.out.println("-> 1.开始测试");
		System.out.println("-> 2.我的测试记录");
		System.out.println("-> 0.返回上一级");
		System.out.println("--------------------");
	}

	/* (non-Javadoc)
	 * @see com.tz.cels.view.IView#showNewWordSubNenu()
	 */
	@Override
	public void showNewWordSubNenu() {
		// TODO Auto-generated method stub
		System.out.println("---------------------");
		System.out.println("-> 1.展示新单词");
		System.out.println("-> 0.返回上一级");
		System.out.println("---------------------");
	}

}
