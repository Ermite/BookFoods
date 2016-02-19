package com.fifth.wcl.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.util.JSONTools;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

@WebServlet("/JSONTest2")
public class JSONTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JSONTest2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		//如果是没有带参数的请求
//		InputStream is = request.getInputStream();
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		
//		byte[] data = new byte[1024];
//		int len = 0;
//		while(-1 != (len = is.read(data))){
//			baos.write(data,0,len);
//		}
//		
//		String json = new String(baos.toByteArray());
//		List<String> list2 = JSONTools.getList(json, String.class);
		
		
		
		String customer_idString=request.getParameter("customer_id");
		System.out.println(customer_idString);
		ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
		try {
			int customer_id=Integer.parseInt(customer_idString);
			List<ShoppingCartItemBean> shoppingCartItemList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(customer_id);
			String jsonStr = JSONTools.getJson(shoppingCartItemList);
			OutputStream os = response.getOutputStream();
			os.write(jsonStr.getBytes());
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
