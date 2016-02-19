package com.fifth.lqk.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.FoodsBean;
import com.fifth.lqk.biz.FoodsBiz;
import com.fifth.lqk.biz.FoodsBizImpl;

/**
 * Servlet implementation class RandomServlet
 */
@WebServlet("/RandomServlet")
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RandomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		FoodsBiz foodsBiz = new FoodsBizImpl();
		int number =foodsBiz.fetchNumber();
		GetRandom getrandom=new GetRandom();
		
		int[] array = getrandom.randomCommon(1, number, 3);
//		System.out.println(array[0]+"--"+array[1]+"--"+array[2]);
		FoodsBean foodsBean = null;
		ArrayList<FoodsBean> foodlist = new ArrayList<FoodsBean>();
		for(int x=0;x<3;x++){
			foodsBean=new FoodsBean();
			foodsBean=foodsBiz.findFoodById(array[x]);
			foodlist.add(foodsBean);
		}
//		System.out.println(foodlist.toString());
		request.setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
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
