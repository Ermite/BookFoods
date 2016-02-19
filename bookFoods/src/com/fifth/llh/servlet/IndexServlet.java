package com.fifth.llh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.CustomerBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.llh.biz.RestaurantsBiz;
import com.fifth.llh.biz.RestaurantsBizImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBean customer0=(CustomerBean)request.getSession().getAttribute("customerBean0");
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		List<RestaurantsBean> restaurantsBeanList = restaurantsBiz.fetchAll();
		request.setAttribute("restaurantsBeanList", restaurantsBeanList);
		request.getSession().setAttribute("customerBean0", customer0);
		request.getRequestDispatcher("./RandomServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
