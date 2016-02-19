package com.fifth.gyj.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fifth.bean.FoodsBean;
import com.fifth.util.JSONTools;

/**
 * Servlet implementation class ReceiveMessageServlet
 */
@WebServlet("/ReceiveMessageServlet")
public class ReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		
		InputStream is = request.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		byte[] data = new byte[1024];
		while(-1 != (len = is.read(data))){
			baos.write(data, 0, len);
		}
		
		String result = new String(baos.toByteArray());
		
		FoodsBean fb = JSONTools.getObject(result, FoodsBean.class);
		
//		boolean flag =biz.login(fb);
	    //boolean flag =biz.login(fb);
		
		OutputStream os = response.getOutputStream();
		
//		os.write((flag+"").getBytes());
		//os.write((flag+"").getBytes());
		os.write(JSONTools.getJson(new FoodsBean()).getBytes());
		os.flush();
		os.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
