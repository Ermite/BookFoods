package com.fifth.lqk.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.RestaurantsBean;
import com.fifth.lqk.biz.RestaurantsBiz;
import com.fifth.lqk.biz.RestaurantsBizImpl;

/**
 * Servlet implementation class SearchRestaurant
 */
@WebServlet("/SearchRestaurant")
public class SearchRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String location = request.getParameter("restaurant_location");
		
		String rsname = request.getParameter("rsname");
//		System.out.println(rsname);
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		List<RestaurantsBean> restaurantsBeanList = restaurantsBiz.findByLocation(rsname,location);
		
		
		
		request.setAttribute("restaurantsBeanList", restaurantsBeanList);
		
		request.getRequestDispatcher("/resturants_lqk.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
