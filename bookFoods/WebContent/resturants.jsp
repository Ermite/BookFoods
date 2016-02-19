<%@page import="com.fifth.bean.CustomerBean"%>
<%@page import="com.fifth.bean.PagingBean"%>
<%@page import="com.fifth.bean.RestaurantsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.fifth.bean.ShoppingCartBean"%>
<%@page import="com.fifth.wcl.biz.FoodsBizImpl"%>
<%@page import="com.fifth.wcl.biz.FoodsBiz"%>
<%@page import="com.fifth.bean.ShoppingCartItemBean"%>
<%@page import="com.fifth.wcl.biz.ShoppingCartBizImpl"%>
<%@page import="com.fifth.wcl.biz.ShoppingCartBiz"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.fifth.bean.MenusBean"%>
<%@page import="com.fifth.bean.FoodsBean"%>
<%@page import="java.util.Map"%>
<html>
<head>


<title>外卖</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Spicemystery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />

<!-- <script src="js/simpleCart.min.js"></script> -->
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

</head>
<%
      CustomerBean customerBean0=(CustomerBean)session.getAttribute("customerBean0");
              
  %>
<body>

	<!-- header -->
	<div class="head-top"></div>
	<div class="header">

		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img src="images/logo.png"
					class="img-responsive" alt=""></a>
			</div>
			<div class="header-left">
				<div class="head-nav">
					<span class="menu"> </span>
					<ul>
						<li ><a href="./IndexServlet">首页</a></li>
						<li class="active"><a href="./ResturantsServlet">餐厅</a></li>
						<li><a href="login.jsp">登录</a></li>
						<li><a href=" contact.jsp">联系我们</a></li>
						<div class="clearfix"></div>
					</ul>
					<!-- script-for-nav -->
					<script>
						$("span.menu").click(function() {
							$(".head-nav ul").slideToggle(300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- script-for-nav -->
				</div>
				<div class="header-right1">
					<%
						if(customerBean0==null){
					%>
					<a href="register.jsp">注册</a> <a href="login.jsp">登录</a>
					<%
						}else{
					%>
					<a href="#"><%=customerBean0.getCustomer_name()%></a>
					<%
						}
					%>
					
					
					
					<%
					ShoppingCartBean shoppingCartBean=null;
					List<ShoppingCartItemBean> shoppingCartItemList=null;
					ShoppingCartItemBean shoppingCartItemBean0=null;
					if(customerBean0!=null){
						int current_id=customerBean0.getCustomer_id();
						ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
						shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						if(shoppingCartBean==null){
							shoppingCartBiz.addShoppingCartByCustomer_id(current_id);
							shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						}else{
						shoppingCartItemList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(current_id);
				      if(shoppingCartItemList==null){
					%>
					购物车为空<a href="./ResturantsServlet">请先预定食物</a>
					<%
					}else{
						
					%>
					
					<% 
					//shoppingCartItemList 当前用户的购物车信息
					FoodsBiz foodsBiz=new FoodsBizImpl();
					FoodsBean foodsBean2=null;
					float total=0;
					int count=0;
					for(ShoppingCartItemBean cartItemBean:shoppingCartItemList){
						int shoppingCart_id=cartItemBean.getShoppingCart_id();
						foodsBean2=foodsBiz.fetchFoodById(cartItemBean.getFood_id());
						shoppingCartItemBean0=cartItemBean;
						float price=(float)foodsBean2.getFood_price();
						int num=cartItemBean.getFood_count();
						total+=price*num;
						count+=num;
						
					}
					%>
					
					
					<div class="cart box_1">
						<a href="checkout_wcl.jsp">
							<h3>
								<span class="simpleCart_total" id="simpleCart_total"><%=total %> </span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"> <%=count %>
								</span> 项)<img src="images/bag.png" alt="">
								
							</h3>
						</a>
						<p>
							<a href="#" class="simpleCart_empty">清空购物车</a>
							<input type="hidden"  value="<%=customerBean0.getCustomer_id()%>"
						    name="customer_id" cid="<%=customerBean0.getCustomer_id()%>" class="customerid"/>
						</p>
						<div class="clearfix"></div>
						
							<%
					 }
					}
					
				} 
				%>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- header -->
<!-- about -->
<%
PagingBean pagingBean = (PagingBean)request.getAttribute("pagingBean");
if(pagingBean!=null){
%>
<div class="orders">
	<div class="container">
<% 
@SuppressWarnings("unchecked")
List<RestaurantsBean> restaurantsBeanList = (List<RestaurantsBean>)request.getAttribute("restaurantsBeanList");
if(restaurantsBeanList!=null){
	
for(RestaurantsBean bean:restaurantsBeanList){

%>

		<div class="order-top">
			<li class="im-g"><a href="#"><img src="images/<%=bean.getRestaurant_img() %>" class="img-responsive" alt=""></a></li>
			<li class="data"><h4>&nbsp;&nbsp;&nbsp;<%=bean.getRestaurant_name() %></h4>
				<p>&nbsp;&nbsp;&nbsp;<%=bean.getRestaurant_location() %></p>
				<P>&nbsp;&nbsp;&nbsp;点击量:<%=bean.getRestaurant_clickrate() %></P>
			</li>
			<li class="bt-nn">
				<a class="morebtn hvr-rectangle-in" href="./FindAllFoodsServlet?restaurant_id=<%=bean.getRestaurant_id()%>">浏览</a>
			</li>
			<div class="clearfix"></div>
		</div>

<%
}
}else{
	%>
	<h3 class="animate-onscroll no-margin-top">无结果</h3>
	<% 
}
%>		
							
	    </div>
	</div>
	<div class="numeric-pagination animate-onscroll" style="text-align:center;" >
						
							<a href="./ResturantsServlet?pageno=<%=pagingBean.getPageno()-1%>" class="button" style="background:#7A9510;color:#fff" >上一页</a>
		<%
		
		for(int i=pagingBean.getPageno(); i<pagingBean.getPageno()+3; i++){
			if(i>pagingBean.getMaxpage()){
				break;
			}
		%>	
							<a href="./ResturantsServlet?pageno=<%=i %>" class="button" style="background:#7A9510;color:#fff"><%=i %></a>
		<%		
		}
	%>							

							<a href="./ResturantsServlet?pageno=<%=pagingBean.getPageno()+1%>" class="button" style="background:#7A9510;color:#fff">下一页</a>
				
						</div>
<%		
}else{
	out.print("无");
}
%>
	<!-- about -->
	<!-- footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>
					Copyrights © 2015 SpiceMystery All rights reserved | Design by <a
						href="http://w3layouts.com/">Android一班第五组</a>
				</p>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
	<!-- footer-->
<script type="text/javascript">
	$(".simpleCart_empty").click(
			function() {
				cid=$(this).parent().find(".customerid").attr("cid");
				total = $("#simpleCart_total").html();
				count = $("#simpleCart_quantity").html();
				total = 0.0;
				count = 0;
				$("#simpleCart_total").html("" + total);
				$("#simpleCart_quantity").html("" + count);
				$.post('./ClearShoppingCartServlet',{customer_id:cid},function(data){
					if(data=='1'){
					}
				});
			});
</script>	
</body>
</html>