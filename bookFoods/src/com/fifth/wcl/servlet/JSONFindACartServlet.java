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

/**
 * Servlet implementation class FindAllFoods
 */
@WebServlet("/JSONFindACartServlet")
public class JSONFindACartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONFindACartServlet() {
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
		FoodsBiz FoodsBiz=new FoodsBizImpl();
		try {
			int customer_id = Integer.parseInt(customer_idString);

			List<CartFoodBean> cartFoodList = new ArrayList<CartFoodBean>();
			cartFoodList=FoodsBiz.fetchACartFoodByCustomer_id(customer_id);
			
			if (cartFoodList != null) {
				String cartFoodListStr = JSON.toJSONString(cartFoodList);
				printWriter.println(cartFoodListStr);
				printWriter.flush();
				printWriter.close();
			} else {
				System.out.println("没有取到cartFoodList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
