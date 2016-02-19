package com.fifth.gyj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.CustomerBean;
import com.fifth.bean.ShoppingCartBean;
import com.fifth.gyj.biz.RegisterBiz;
import com.fifth.gyj.biz.RegisterBizImpl;
import com.fifth.tyy.biz.CustomerBiz;
import com.fifth.tyy.biz.CustomerBizImpl;
import com.fifth.wcl.biz.ShoppingCartBiz;
import com.fifth.wcl.biz.ShoppingCartBizImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cusername = request.getParameter("cusername");
		String cemail = request.getParameter("cemail");
		String password = request.getParameter("password");
		String pwdconfirm = request.getParameter("pwdconfirm");

		if (cusername == null || cusername.trim().equals("")) {
			request.setAttribute("message", "用户名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (password == null || password.trim().equals("")
				|| password.length() < 6) {
			request.setAttribute("temp_cusername", cusername);
			request.setAttribute("temp_cemail", cemail);
			request.setAttribute("message", "密码不符合要求(不小于6位)");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (pwdconfirm == null || pwdconfirm.trim().equals("")
				|| !pwdconfirm.trim().equals(request.getParameter("password"))) {
			request.setAttribute("temp_cusername", cusername);
			request.setAttribute("temp_cemail", cemail);
			request.setAttribute("message", "请确认两次密码一致");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (cemail.matches("\\w+@\\w+\\.\\w+")) {
			CustomerBean customerBean = new CustomerBean();
			customerBean.setCustomer_name(cusername);
			customerBean.setCustomer_email(cemail);
			customerBean.setCustomer_password(password);

			RegisterBiz registerBiz = new RegisterBizImpl();
			CustomerBiz customerBiz = new CustomerBizImpl();
			ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
			ShoppingCartBean shoppingCartBean=null;
			int cusernameid = registerBiz.fetchIdByCemail(cemail);

			if (cusernameid == 0) {

				int rows = registerBiz.register(customerBean);
				if (rows == 1) {
					CustomerBean bean2=new CustomerBean();
					bean2=customerBiz.fetchCustomerByEmail(cemail);
					shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(bean2.getCustomer_id());
					if(shoppingCartBean==null){
						shoppingCartBiz.addShoppingCartByCustomer_id(bean2.getCustomer_id());
						System.out.println("在购物车中注册成功");
					}
					request.getSession().setAttribute("current_cemail", cemail);
					request.setAttribute("message", "注册成功...");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				} else {
					request.setAttribute("message", "注册失败，请重新注册！");
					request.getRequestDispatcher("register.jsp").forward(
							request, response);
				}

			} else {
				request.setAttribute("message", "该邮箱已注册");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}

		} else {
			request.setAttribute("temp_cusername", cusername);
			request.setAttribute("message", "邮箱格式不正确");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
