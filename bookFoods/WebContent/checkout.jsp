<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.fifth.bean.ShoppingCartItemBean"%>
<%@page import="com.fifth.bean.FoodsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fifth.bean.CustomerBean"%>
<html>
<head>
<title>外卖</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Spicemystery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700' rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script src="js/simpleCart.min.js"> </script>		
</head>
<%
      CustomerBean customerBean0=(CustomerBean)session.getAttribute("customerBean0");
              
  %>
<body>
<%
		CustomerBean customer=(CustomerBean)request.getAttribute("customer");
			ArrayList<FoodsBean> foodList =(ArrayList<FoodsBean>)request.getAttribute("foodList");
			ArrayList<ShoppingCartItemBean> shoppingCartItemList =(ArrayList<ShoppingCartItemBean>)request.getAttribute("shoppingCartItemList");
			
			if (customer != null) {
				String customer_name = customer.getCustomer_name();
			}
			
			String temp_order_str=request.getParameter("temp_order");
			int temp_order =0;
			if(temp_order_str==null){
				temp_order_str="0";
			}else{
				temp_order = Integer.parseInt(temp_order_str);
			}
			temp_order=1;
	%>
<!-- header -->
<div class="head-top">
			
		</div>
	<div class="header">
		
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img src="images/logo.png" class="img-responsive" alt=""></a>
			</div>
			<div class="header-left">
				<div class="head-nav">
					<span class="menu"> </span>
						<ul>
							<li class="active"><a href="index.jsp">首页</a></li>
							<li><a href=" resturants.jsp">餐厅</a></li>
							<li><a href="login.jsp">登录</a></li>
							<li><a href=" contact.jsp">联系我们</a></li>
								<div class="clearfix"> </div>		
						</ul>
								<!-- script-for-nav -->
							<script>
								$( "span.menu" ).click(function() {
								  $( ".head-nav ul" ).slideToggle(300, function() {
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
					<a href="register.jsp">注册</a>
					<a href="login.jsp">登录</a>
					<%
					}else{
					%>
					<a href="#"><%=customerBean0.getCustomer_name() %></a>
					<%
					}
					%>
						<div class="cart box_1">
							<a href="./findAllShoppingCartItem">
								<h3> <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span> 项)<img src="images/bag.png" alt=""></h3>
							</a>	
							<p><a href="javascript:;" class="simpleCart_empty">空空如也</a></p>
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
					<div class="clearfix"> </div>
			</div>
	</div>
	<!-- header -->
	<!-- checkout -->
	<div class="cart-items">
		<div class="container">
			<h1>我的购物车</h1>
			<script>
				$(document).ready(function(c) {
					$('.close1').on('click', function(c) {
						$('.cart-header').fadeOut('slow', function(c) {
							$('.cart-header').remove();
						});
					});
				});
			</script>
			<div class="cart-header">
				<div class="close1"></div>
				<div class="cart-sec simpleCart_shelfItem">
					<%
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
					%>
					<div class="cart-item cyc">
						<img src="images/6p.jpg" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3>
							<a href="#"><%=foods_Name%></a><span>预定时间:<%=food_booktime%></span>
						</h3>
						<ul class="qty">
							<li><p>
									单价:<%=food_Price%></p></li>
							<li><p>
									数量:<%=food_count%></p></li>
							<%
								if (food_delivery_type == 0) {
							%>
							<li><p>无运费</p></li>
							<%
								}
												if (food_delivery_type == 1) {
							%>
							<li><p>
									运费:
									<%=food_charge%></p></li>

							<%
								}
							%>

						</ul>
						<div class="delivery">
							<p>
								总计: $<%=food_Price * food_count%></p>
							<span>预计1-1:30小时送达</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>
					<%
						}
								}
							}
						}
					%>

				</div>

			</div>
			<a
				href="./findAllShoppingCartItem?temp_order=1">去下单</a>
		</div>
	</div>
	</div>
	<!-- checkout -->
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
</body>
</html>