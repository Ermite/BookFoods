package com.fifth.wcl.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fifth.bean.CartFoodBean;
import com.fifth.bean.FoodsBean;
import com.fifth.bean.MenusBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.util.JSONTools;
import com.fifth.wcl.biz.FoodsBiz;
import com.fifth.wcl.biz.FoodsBizImpl;
import com.fifth.wcl.biz.MenusBiz;
import com.fifth.wcl.biz.MenusBizImpl;
import com.fifth.wcl.biz.RestaurantsBiz;
import com.fifth.wcl.biz.RestaurantsBizImpl;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class FindAllFoods
 */
@WebServlet("/JSONClearCartServlet")
public class JSONClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONClearCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter=response.getWriter();
		String customer_idString=request.getParameter("customer_id");
		System.out.println(customer_idString);
		ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
		try {
			int customer_id=Integer.parseInt(customer_idString);
			int result=shoppingCartBiz.clearShoppingCartByCid(customer_id);
			if (result>1) {
				System.out.println("清空"+customer_id+"购物车成功");
				printWriter.write("清空用户ID为"+customer_id+"的购物车成功");
			}else{
				System.out.println("清空"+customer_id+"购物车失败");
				printWriter.write("清空用户ID为"+customer_id+"的购物车失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.write("false");
		}
		printWriter.flush();
		printWriter.close();
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
