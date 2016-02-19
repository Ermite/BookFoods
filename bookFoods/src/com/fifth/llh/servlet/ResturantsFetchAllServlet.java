package com.fifth.llh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.PagingBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.llh.biz.RestaurantsBiz;
import com.fifth.llh.biz.RestaurantsBizImpl;
import com.fifth.util.PagingUtil;

/**
 * Servlet implementation class ResturantsServlet
 * ResturantsFetchAllServlet.java
 */
@WebServlet("/ResturantsServlet")
public class ResturantsFetchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResturantsFetchAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pagenoString = request.getParameter("pageno");
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		List<RestaurantsBean> restaurantsBeanList = restaurantsBiz.fetchAll();
		PagingBean pagingBean = PagingUtil.getPagingBean(pagenoString, restaurantsBeanList);
		
		List<RestaurantsBean> restaurantsBeanListPage = restaurantsBiz.fetchAll(pagingBean.getPageno());
		request.setAttribute("restaurantsBeanList", restaurantsBeanListPage);
		request.setAttribute("pagingBean", pagingBean);
		request.getRequestDispatcher("/resturants.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
