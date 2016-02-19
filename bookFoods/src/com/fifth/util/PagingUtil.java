package com.fifth.util;

import java.util.List;

import com.fifth.bean.PagingBean;
import com.fifth.bean.RestaurantsBean;


public class PagingUtil{
	
	public static PagingBean getPagingBean(String pagenoString, List<RestaurantsBean> restaurantsBeanList){
		PagingBean pagingBean = null;
		int pageno = 1;
		int maxpage = 1;
		
		if(restaurantsBeanList != null){
			maxpage = restaurantsBeanList.size()%PagingBean.MAX_PAGE_SIZE == 0 ? restaurantsBeanList.size()/PagingBean.MAX_PAGE_SIZE:
				restaurantsBeanList.size()/PagingBean.MAX_PAGE_SIZE+1;
		}
		
		if(pagenoString != null){
			pageno = Integer.parseInt(pagenoString);
		}
		
		if(pageno < 1){
			pageno = 1;
		}
		
		if(pageno > maxpage){
			pageno = maxpage;
		}
		pagingBean = new PagingBean(pageno, maxpage);
		return pagingBean;
	}
}
