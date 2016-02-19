package com.fifth.wcl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;
import com.fifth.wcl.biz.ShoppingCartItemBiz;
import com.fifth.wcl.biz.ShoppingCartItemBizImpl;

/**
 * Servlet implementation class UpdateShoppingCard
 */
@WebServlet("/UpdateShoppingCard")
public class UpdateShoppingCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String customer_idString=request.getParameter("customer_id");
		String food_idString=request.getParameter("food_id");
		String shoppingCart_idString=request.getParameter("shoppingCart_id");
		
//		String fcountString=request.getParameter("tid");
//		System.out.println(fcountString);
		String buy_numberString=request.getParameter("buy_number");
		String shoppingCartItem_idString=request.getParameter("shoppingCartItem_id");
		if(customer_idString!=null&&food_idString!=null&&shoppingCart_idString!=null){
			
			System.out.println("用户ID："+customer_idString+" 食物ID："+food_idString+" 购物车ID： "+shoppingCart_idString );
		try {
			int customer_id=Integer.parseInt(customer_idString);
			int food_id=Integer.parseInt(food_idString);
			int shoppingCart_id=Integer.parseInt(shoppingCart_idString);
			ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
				
			ShoppingCartItemBean shoppingCartItemBean=null;
			List<ShoppingCartItemBean> shoppingCartItemBeanList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(customer_id);
			
			
			if(shoppingCartItemBeanList!=null){
				//购物车不空，且存在该商品
				for (ShoppingCartItemBean tempBean:shoppingCartItemBeanList) {
					if(food_id==tempBean.getFood_id()){
						shoppingCartItemBean=tempBean;
						shoppingCartBiz.changeFoodNumById(tempBean.getFood_id());
				    }
				}
				//购物车不空，但不存在该商品
				if(shoppingCartItemBean==null){
					shoppingCartItemBean=new ShoppingCartItemBean();
					shoppingCartItemBean.setCustomer_id(customer_id);
					shoppingCartItemBean.setFood_id(food_id);
					shoppingCartItemBean.setShoppingCart_id(shoppingCart_id);
					shoppingCartBiz.addNewShoppingCartItem(shoppingCartItemBean);
				}
				
				
			}else {
				//购物车为空
				shoppingCartItemBeanList=new ArrayList<ShoppingCartItemBean>();
				shoppingCartItemBean=new ShoppingCartItemBean();
				shoppingCartItemBean.setCustomer_id(customer_id);
				shoppingCartItemBean.setFood_id(food_id);
				shoppingCartItemBean.setShoppingCart_id(shoppingCart_id);
				shoppingCartBiz.addNewShoppingCartItem(shoppingCartItemBean);
			}
			System.out.println("执行了异步更新shoppingcarditem操作，具体更新的商品id为："+food_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else {
			if(buy_numberString!=null&&shoppingCartItem_idString!=null){
				System.out.println(buy_numberString+"   "+shoppingCartItem_idString);
				try {
					int shoppingCartItem_id=Integer.parseInt(shoppingCartItem_idString);
					int buy_number=Integer.parseInt(buy_numberString);
					ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
					shoppingCartBiz.changeFoodNumById(shoppingCartItem_id,buy_number);
					System.out.println("执行了异步更新shoppingcarditem操作，具体更新的购物车项目id为："+shoppingCartItem_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else{
				System.out.println(shoppingCartItem_idString);
				try {
					int shoppingCartItem_id=Integer.parseInt(shoppingCartItem_idString);
					ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
					shoppingCartBiz.deleteCartItemById(shoppingCartItem_id);
					System.out.println("执行了异步更新shoppingcarditem操作，具体删除的购物车项目id为："+shoppingCartItem_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
