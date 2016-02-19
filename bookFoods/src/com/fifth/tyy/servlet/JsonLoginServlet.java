package com.fifth.tyy.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fifth.bean.CustomerBean;
import com.fifth.tyy.biz.CustomerBiz;
import com.fifth.tyy.biz.CustomerBizImpl;
import com.fifth.util.JSONTools;

/**
 * Servlet implementation class JsonLoginServlet
 */
@WebServlet("/JsonLoginServlet")
public class JsonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		InputStream ios = request.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int length = 0;
		byte[] d = new byte[1024];
		while (-1 != (length = ios.read(d))) {
			baos.write(d, 0, length);
		}
		String objString = new String(baos.toByteArray());
		CustomerBean bean = JSONTools.getObject(objString, CustomerBean.class);
		System.out.println("----"+bean);
		CustomerBiz customerBiz = new CustomerBizImpl();
		CustomerBean bean2 = customerBiz.loginapp(bean);
		PrintWriter writer = response.getWriter();
		if (bean2 != null) {
			String orderString = JSON.toJSONString(bean2);
			System.out.println(orderString);
			writer.write(orderString);
		}
		writer.flush();
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
