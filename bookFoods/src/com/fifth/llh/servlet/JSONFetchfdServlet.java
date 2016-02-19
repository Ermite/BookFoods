package com.fifth.llh.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fifth.bean.RestaurantsBean;
import com.fifth.llh.biz.RestaurantsBiz;
import com.fifth.llh.biz.RestaurantsBizImpl;
import com.fifth.util.JSONTools;

/**
 * Servlet implementation class JSONFetchfdServlet
 */
@WebServlet("/JSONFetchfdServlet")
public class JSONFetchfdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONFetchfdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		RestaurantsBiz restaurantsBiz = new RestaurantsBizImpl();
		PrintWriter pw = response.getWriter();
		List<RestaurantsBean> restaurantsBeanList = restaurantsBiz.fetchAll();
		if(restaurantsBeanList!= null){
			pw.println(JSON.toJSONString(restaurantsBeanList));
			
		}else{
			System.out.println("==================================");
		}
		pw.flush();
		pw.close();
		
//		String jsonStr = JSONTools.getJson(restaurantsBeanList);
//		OutputStream os = response.getOutputStream();
//		os.write(jsonStr.getBytes());
//		os.flush();
//		os.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
