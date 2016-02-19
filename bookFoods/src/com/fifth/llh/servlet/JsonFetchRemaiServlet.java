package com.fifth.llh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fifth.bean.FoodsBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.llh.biz.RestaurantsBiz;
import com.fifth.llh.biz.RestaurantsBizImpl;

/**
 * Servlet implementation class JsonFetchRemaiServlet
 */
@WebServlet("/JsonFetchRemaiServlet")
public class JsonFetchRemaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonFetchRemaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		PrintWriter pw = response.getWriter();
		List<FoodsBean> foodsBeanList = restaurantsBiz.fetchRemai();
		if(foodsBeanList!= null){
			pw.println(JSON.toJSONString(foodsBeanList));
			
		}else{
			System.out.println("==================================");
		}
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
