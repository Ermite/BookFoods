package com.fifth.wcl.biz;

import java.util.ArrayList;
import java.util.List;

import com.fifth.bean.ShoppingCartBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.wcl.dao.ShoppingCartDao;
import com.fifth.wcl.dao.ShoppingCartDaoImpl;

public class ShoppingCartBizImpl implements ShoppingCartBiz {
	ShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl(); 

	@Override
	public ArrayList<ShoppingCartItemBean> fetchshoppingCartItemByCustomer_id(
			int current_id) {
		ArrayList<ShoppingCartItemBean> shoppingCartItemBeanList=null;
		try {
			shoppingCartItemBeanList=shoppingCartDao.fetchshoppingCartItemByCustomer_id(current_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartItemBeanList;
	}

	@Override
	public void changeFoodNumById(int food_id) {
		try {
			shoppingCartDao.changeFoodNumById(food_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addNewShoppingCartItem(ShoppingCartItemBean shoppingCartItemBean) {
		try {
			shoppingCartDao.addNewShoppingCartItem(shoppingCartItemBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ShoppingCartBean fetchshoppingCartByCustomer_id(int current_id) {
		ShoppingCartBean shoppingCartBean=null;
		try {
			shoppingCartBean=shoppingCartDao.fetchshoppingCartByCustomer_id(current_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartBean;
	}

	@Override
	public void addShoppingCartByCustomer_id(int current_id) {
		try {
			shoppingCartDao.addShoppingCartByCustomer_id(current_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int clearShoppingCartByCid(int customer_id) {
		int result=0;
		try {
			result=shoppingCartDao.clearShoppingCartByCid(customer_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void changeFoodNumById(int shoppingCartItem_id, int buy_number) {
		try {
			shoppingCartDao.changeFoodNumById(shoppingCartItem_id,buy_number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCartItemById(int shoppingCartItem_id) {
		try {
			shoppingCartDao.deleteCartItemById(shoppingCartItem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
