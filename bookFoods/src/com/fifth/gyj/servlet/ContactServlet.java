package com.fifth.gyj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.MessagesBean;
import com.fifth.gyj.biz.ContactBiz;
import com.fifth.gyj.biz.ContactBizImpl;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phoneString = request.getParameter("phone");
		String city = request.getParameter("city");
		String message = request.getParameter("message");

		int phone = Integer.parseInt(phoneString);
		if (username == null || username.trim().equals("")) {
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		} else if (phoneString == null || phoneString.trim().equals("")) {
			request.setAttribute("temp_cusername", username);
			request.setAttribute("temp_cemail", email);
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		} else if (city == null || city.trim().equals("")) {
			request.setAttribute("temp_cusername", username);
			request.setAttribute("temp_cemail", email);
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		} else if (message == null || message.trim().equals("")) {
			request.setAttribute("temp_cusername", username);
			request.setAttribute("temp_cemail", email);
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		} else if (email.matches("\\w+@\\w+\\.\\w+")) {
			MessagesBean messagesBean = new MessagesBean();
			messagesBean.setCname(username);
			messagesBean.setCemail(email);
			messagesBean.setCphone(phone);
			messagesBean.setCityname(city);
			messagesBean.setMessage_info(message);

			ContactBiz contactBiz = new ContactBizImpl();

			int rows = contactBiz.contact(messagesBean);
			if (rows == 1) {
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				request.setAttribute("message", "发送失败，请重新发送！");
				request.getRequestDispatcher("contact.jsp").forward(request,
						response);
			}

		} else {
			request.setAttribute("message", "邮箱格式不正确");
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
