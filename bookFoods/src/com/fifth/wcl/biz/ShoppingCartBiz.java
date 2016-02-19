package com.fifth.wcl.biz;

import java.util.ArrayList;

import com.fifth.bean.ShoppingCartBean;
import com.fifth.bean.ShoppingCartItemBean;

public interface ShoppingCartBiz {
	
	public ArrayList<ShoppingCartItemBean> fetchshoppingCartItemByCustomer_id(int current_id);

	public void changeFoodNumById(int food_id);

	public void addNewShoppingCartItem(ShoppingCartItemBean shoppingCartItemBean);
	public ShoppingCartBean fetchshoppingCartByCustomer_id(int current_id);
	public void addShoppingCartByCustomer_id(int current_id);

	public int clearShoppingCartByCid(int customer_id);

	public void changeFoodNumById(int shoppingCartItem_id, int buy_number);

	public void deleteCartItemById(int shoppingCartItem_id);

}
