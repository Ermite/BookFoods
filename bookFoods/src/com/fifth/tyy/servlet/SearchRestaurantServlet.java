package com.fifth.tyy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fifth.bean.RestaurantsBean;
import com.fifth.tyy.biz.RestaurantsBiz;
import com.fifth.tyy.biz.RestaurantsBizImpl;


@WebServlet("/SearchRestaurantServlet")
public class SearchRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchRestaurantServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String restaurant_name = request.getParameter("restaurant_name");
		String restaurant_location = request.getParameter("restaurant_location");
		String restaurant_typeString = request.getParameter("restaurant_type");
		String restaurant_clickrateString = request.getParameter("restaurant_clickrate");
		String restaurant_img = request.getParameter("restaurant_img");
		
		int restaurant_type =Integer.parseInt(restaurant_typeString);
		int restaurant_clickrate = Integer.parseInt(restaurant_clickrateString);
		RestaurantsBean restaurantsBean = new RestaurantsBean();
		restaurantsBean.setRestaurant_name(restaurant_name);
		restaurantsBean.setRestaurant_location(restaurant_location);
		restaurantsBean.setRestaurant_type(restaurant_type);
		restaurantsBean.setRestaurant_clickrate(restaurant_clickrate);
		restaurantsBean.setRestaurant_img(restaurant_img);
		
		
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		

		List<RestaurantsBean> restaurantsBeanList = restaurantsBiz
				.fetchSearchRestaurantsList(restaurantsBean);
		session.setAttribute("RestaurantsBeanList", restaurantsBeanList);
		session.setAttribute("RestaurantsBean", restaurantsBean);
		request.getRequestDispatcher("restaurants.jsp").forward(request,
				response);
	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
