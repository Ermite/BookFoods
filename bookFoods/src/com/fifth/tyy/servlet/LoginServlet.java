package com.fifth.tyy.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.CustomerBean;
import com.fifth.tyy.biz.CustomerBiz;
import com.fifth.tyy.biz.CustomerBizImpl;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cemail = request.getParameter("cemail");
		String cpassword = request.getParameter("cpassword");
		
		if (cemail == null || cemail.trim().equals("")) {//
			request.setAttribute("message", "邮箱不能为空");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else if (cpassword == null || cpassword.trim().equals("")) {//
			
			request.setAttribute("message", "密码不能为空");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
	 	} else if(cemail.matches("\\w+@\\w+\\.\\w+")){
	 		CustomerBean customerBean = new CustomerBean();//
			customerBean.setCustomer_email(cemail);
			customerBean.setCustomer_password(cpassword);

			CustomerBiz customerBiz = new CustomerBizImpl();//
			try {
				int result = customerBiz.login(customerBean);
				if (result != 0) {
					request.setAttribute("message", "登录成功！");
					CustomerBean customer0= new CustomerBean();
					customer0=customerBiz.fetchCustomerByEmail(cemail);
					request.getSession().setAttribute("customerBean0", customer0);
					request.getRequestDispatcher("./IndexServlet")
							.forward(request, response);
					
				} else {
					request.setAttribute("message", "邮箱或密码不存在，请确认后重新登录！");
					request.getRequestDispatcher("./IndexServlet").forward(request,
							response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	 	}else{
	 		request.setAttribute("message", "邮箱格式不正确，请重新登录！");
			request.getRequestDispatcher("./IndexServlet").forward(request,
					response);
	 	}	
	}
}
