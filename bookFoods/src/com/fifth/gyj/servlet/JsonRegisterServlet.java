package com.fifth.gyj.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.CustomerBean;
import com.fifth.bean.ShoppingCartBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.gyj.biz.RegisterBiz;
import com.fifth.gyj.biz.RegisterBizImpl;
import com.fifth.tyy.biz.CustomerBiz;
import com.fifth.tyy.biz.CustomerBizImpl;
import com.fifth.util.JSONTools;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class JsonRegisterServlet
 */
@WebServlet("/JsonRegisterServlet")
public class JsonRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		InputStream ios = request.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CustomerBean customer0=null;
		int row =0;
		int length = 0;
		byte[] d = new byte[1024];
		while (-1 != (length = ios.read(d))) {
			baos.write(d, 0, length);
		}
		String objString = new String(baos.toByteArray());
		CustomerBean bean = JSONTools.getObject(objString, CustomerBean.class);

		RegisterBiz registerBiz = new RegisterBizImpl();
		CustomerBiz customerBiz = new CustomerBizImpl();
		ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
		customer0=customerBiz.fetchCustomerByEmail(bean.getCustomer_email());
		if(customer0==null){
			row = registerBiz.register(bean);
		}
		PrintWriter writer = response.getWriter();
		if (row == 1) {
			CustomerBean bean2=new CustomerBean();
			bean2=customerBiz.fetchCustomerByEmail(bean.getCustomer_email());
			ShoppingCartBean shoppingCartBean=null;
			shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(bean2.getCustomer_id());
			if(shoppingCartBean==null){
				shoppingCartBiz.addShoppingCartByCustomer_id(bean2.getCustomer_id());
				System.out.println("在购物车中注册成功");
			}
			writer.write("true");
		} else {
			writer.write("false");
		}
		writer.flush();
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	
	}

}
