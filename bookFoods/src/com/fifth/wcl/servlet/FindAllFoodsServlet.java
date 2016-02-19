package com.fifth.wcl.servlet;

import java.io.IOException;
import java.io.OutputStream;
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
@WebServlet("/FindAllFoodsServlet")
public class FindAllFoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllFoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String restaurant_idString=request.getParameter("restaurant_id");
		MenusBiz menusBiz=new MenusBizImpl();
		FoodsBiz FoodsBiz=new FoodsBizImpl();
		int restaurant_id=Integer.parseInt(restaurant_idString);
		//int restaurant_id=1;
		List<Map<FoodsBean,Integer>> foodslist=new ArrayList<Map<FoodsBean,Integer>>();
		
		List<MenusBean> menusBeanList = menusBiz.fetchAllMenusByrestaurant_id(restaurant_id);
		if (menusBeanList!=null) {
			for (MenusBean menusBean:menusBeanList) {
				Map<FoodsBean,Integer> map=new IdentityHashMap<FoodsBean,Integer>();
				
				map = FoodsBiz.fetchAllfoodsbByMenu_id(menusBean.getMenu_id());
				foodslist.add(map);
			}
			request.setAttribute("foodslist", foodslist);
			request.setAttribute("menusBeanList", menusBeanList);
			request.getRequestDispatcher("orders_wcl.jsp").forward(request,
					response);
			
		}else{
			request.getRequestDispatcher("./ResturantsServlet").forward(request,
					response);
		}
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
