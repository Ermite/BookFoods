<%@page import="com.fifth.bean.ShoppingCartItemBean"%>
<%@page import="com.fifth.bean.CustomerBean"%>
<%@page import="com.fifth.bean.FoodsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>下单页面</title>
</head>
<body>
	<%
		CustomerBean customer = (CustomerBean) request
				.getAttribute("customer");
		ArrayList<FoodsBean> foodList = (ArrayList<FoodsBean>) request
				.getAttribute("foodList");
		ArrayList<ShoppingCartItemBean> shoppingCartItemList = (ArrayList<ShoppingCartItemBean>) request
				.getAttribute("shoppingCartItemList");

		if (customer != null) {
			String customer_name = customer.getCustomer_name();
		}
	%>
	<h3>我的订单</h3>
	<h3>订单编号：</h3>
	<table>
	<tr>
			<td>食品名称</td>
			<td>购买数量</td>
			<td>食品价格</td>
			<td>运费</td>
			<td>预定时间</td>
			<td>共计</td>
		</tr>
		<%
		double total = 0;
		double temp_total = 0;
						if (shoppingCartItemList != null) {
							for (ShoppingCartItemBean shoppingCartItemBean : shoppingCartItemList) {

								String food_booktime = shoppingCartItemBean
										.getFood_booktime();
								int food_count = shoppingCartItemBean.getFood_count();

								if (foodList != null) {
									for (FoodsBean foodsBean : foodList) {
										String foods_Name = foodsBean.getFood_name();
										String food_img = foodsBean.getFood_img();
										double food_Price = foodsBean.getFood_price();
										int food_Sale = foodsBean.getFood_sale();
										int food_delivery_type = foodsBean
												.getFood_delivery_type();
										double food_charge = foodsBean.getFood_charge();
										temp_total=(food_Price*food_count)+food_charge;
										total=total+temp_total;
					%>

		<tr>
			<td><%=foods_Name%></td>
			<td><%=food_count%></td>
			<td><%=food_Price%></td>
			<td><%=food_charge%></td>
			<td><%=food_booktime%></td>
			<td><%=temp_total %></td>
		</tr>
		<%
						}
								}
							}
						}
					%>
					<tr>
						<td>总价:<%=total %></td>
					</tr>
	</table>
</body>
</html>