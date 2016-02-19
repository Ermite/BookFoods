package com.fifth.lqk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fifth.bean.CustomerBean;
import com.fifth.bean.FoodsBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.lqk.biz.CustomerBiz;
import com.fifth.lqk.biz.CustomerBizImpl;
import com.fifth.lqk.biz.FoodsBiz;
import com.fifth.lqk.biz.FoodsBizImpl;
import com.fifth.lqk.biz.ShoppingCartItemBiz;
import com.fifth.lqk.biz.ShoppingCartItemBizImpl;

/**
 * Servlet implementation class findAllShoppingCartItem
 */
@WebServlet("/findAllShoppingCartItem")
public class findAllShoppingCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public findAllShoppingCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String temp_order_str=request.getParameter("temp_order");
			int temp_order =0;
			if(temp_order_str==null){
				temp_order_str="0";
			}else{
				temp_order = Integer.parseInt(temp_order_str);
			}
			

		request.setCharacterEncoding("utf-8");
		ShoppingCartItemBiz shoppingCartItemBiz = new ShoppingCartItemBizImpl();
		ArrayList<ShoppingCartItemBean> shoppingCartItemList = shoppingCartItemBiz
				.findAllShoppingCartItem();
		if (shoppingCartItemList != null) {
			for (ShoppingCartItemBean shoppingCartItemBean : shoppingCartItemList) {
				int customer_id = shoppingCartItemBean.getCustomer_id();
				int food_id = shoppingCartItemBean.getFood_id();
				FoodsBiz foodsBiz = new FoodsBizImpl();
				CustomerBiz customerBiz = new CustomerBizImpl();
				CustomerBean customer = customerBiz
						.findCustomerById(customer_id);
				if (customer != null) {

					request.setAttribute("customer", customer);
				}
				
				FoodsBean foodList = foodsBiz.findFoodById(food_id);
				if (foodList != null) {
					request.setAttribute("foodList", foodList);
				}

			}
			request.setAttribute("shoppingCartItemList", shoppingCartItemList);
		}
		if (temp_order == 1) {
			request.getRequestDispatcher("placeorder.jsp").forward(request,
					response);

		} else {
			request.getRequestDispatcher("checkout.jsp").forward(request,
					response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
