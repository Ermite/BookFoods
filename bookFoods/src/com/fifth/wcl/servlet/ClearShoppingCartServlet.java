package com.fifth.wcl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class ClearShoppingCartServlet
 */
@WebServlet("/ClearShoppingCartServlet")
public class ClearShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String customer_idString=request.getParameter("customer_id");
		ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
		try {
			int customer_id=Integer.parseInt(customer_idString);
			int result=shoppingCartBiz.clearShoppingCartByCid(customer_id);
			if (result>1) {
				System.out.println("清空"+customer_id+"购物车成功");
			}else{
				System.out.println("清空"+customer_id+"购物车失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
