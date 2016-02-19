package com.fifth.wcl.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fifth.bean.FoodsBean;
import com.fifth.bean.MenusBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.util.JSONTools;
import com.fifth.wcl.biz.FoodsBiz;
import com.fifth.wcl.biz.FoodsBizImpl;
import com.fifth.wcl.biz.MenusBiz;
import com.fifth.wcl.biz.MenusBizImpl;
import com.fifth.wcl.biz.RestaurantsBiz;
import com.fifth.wcl.biz.RestaurantsBizImpl;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class FindAllFoods
 */
@WebServlet("/JSONUpdateCartServlet")
public class JSONUpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONUpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter=response.getWriter();
		String customer_idString=request.getParameter("customer_id");
		String food_idString=request.getParameter("food_id");
		String shoppingCart_idString=request.getParameter("shoppingCart_id");
//		String fcountString=request.getParameter("fcount");
//		System.out.println(fcountString);
		
		String buy_numberString=request.getParameter("buy_number");
		String shoppingCartItem_idString=request.getParameter("shoppingCartItem_id");
		
		if(customer_idString!=null&&food_idString!=null&&shoppingCart_idString!=null){
			
			System.out.println(customer_idString+" "+food_idString+"  "+shoppingCart_idString );
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
			
				
			printWriter.write("更新"+shoppingCart_id+"成功！");
				
			System.out.println("执行了异步更新shoppingcarditem操作，具体更新的商品id为："+food_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.write("false");
		}
		}else {
			if(buy_numberString!=null&&shoppingCartItem_idString!=null){
				System.out.println("数量："+buy_numberString+"购物车项目ID："+shoppingCartItem_idString);
				try {
					int shoppingCartItem_id=Integer.parseInt(shoppingCartItem_idString);
					int buy_number=Integer.parseInt(buy_numberString);
					ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
					shoppingCartBiz.changeFoodNumById(shoppingCartItem_id,buy_number);
					printWriter.write("更新"+shoppingCartItem_idString+"成功！");
					System.out.println("执行了异步更新shoppingcarditem操作，具体更新的购物车项目id为："+shoppingCartItem_id);
				} catch (Exception e) {
					e.printStackTrace();
					printWriter.write("false");
				}
				
			}else{
				System.out.println("购物车项目ID："+shoppingCartItem_idString);
				try {
					int shoppingCartItem_id=Integer.parseInt(shoppingCartItem_idString);
					ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
					shoppingCartBiz.deleteCartItemById(shoppingCartItem_id);
					System.out.println("执行了异步更新shoppingcarditem操作，具体删除的购物车项目id为："+shoppingCartItem_id);
					printWriter.write("删除"+shoppingCartItem_idString+"成功！");
				} catch (Exception e) {
					e.printStackTrace();
					printWriter.write("false");
				}
			}
		}
		printWriter.flush();
		printWriter.close();
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
