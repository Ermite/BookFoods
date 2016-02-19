package com.fifth.bean;

/**
 * @功能 对页码属性进行封装。其中有俩个属性（当前页码，最大页码）
 * @author 李智
 * @时间 2015-08-26
 */
public class PagingBean {
	public static int MAX_PAGE_SIZE = 4;
	private int pageno;
	private int maxpage;
	public PagingBean(int pageno, int maxpage) {
		this.pageno = pageno;
		this.maxpage = maxpage;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
}
