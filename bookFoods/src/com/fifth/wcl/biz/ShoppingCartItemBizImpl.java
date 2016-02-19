package com.fifth.wcl.biz;

import java.util.ArrayList;

import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.lqk.dao.ShoppingCartItemDao;
import com.fifth.lqk.dao.ShoppingCartItemDaoImpl;

public class ShoppingCartItemBizImpl implements ShoppingCartItemBiz {
	ShoppingCartItemDao shoppingCartItemDao = new ShoppingCartItemDaoImpl();
	@Override
	public ArrayList<ShoppingCartItemBean> findAllShoppingCartItem() {
		ArrayList<ShoppingCartItemBean> list=null;
		try{
			list=shoppingCartItemDao.findAllShoppingCartItem();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return list;
	}

}
