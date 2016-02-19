package com.fifth.wcl.dao;

import java.util.ArrayList;

import com.fifth.bean.ShoppingCartBean;
import com.fifth.bean.ShoppingCartItemBean;

public interface ShoppingCartDao {

	public ArrayList<ShoppingCartItemBean> fetchshoppingCartItemByCustomer_id(
			int current_id)throws Exception;

	public void changeFoodNumById(int food_id)throws Exception;

	public void addNewShoppingCartItem(ShoppingCartItemBean shoppingCartItemBean)throws Exception;

	public ShoppingCartBean fetchshoppingCartByCustomer_id(int current_id)throws Exception;

	public void addShoppingCartByCustomer_id(int current_id)throws Exception;

	public int clearShoppingCartByCid(int customer_id)throws Exception;

	public void changeFoodNumById(int shoppingCartItem_id, int buy_number)throws Exception;

	public void deleteCartItemById(int shoppingCartItem_id)throws Exception;

}
