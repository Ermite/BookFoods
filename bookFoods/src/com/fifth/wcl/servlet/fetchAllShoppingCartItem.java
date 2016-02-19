package com.fifth.wcl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class fetchAllShoppingCartItem
 */
@WebServlet("/fetchAllShoppingCartItem")
public class fetchAllShoppingCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchAllShoppingCartItem() {
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
			List<ShoppingCartItemBean> shoppingCartItemList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(customer_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
