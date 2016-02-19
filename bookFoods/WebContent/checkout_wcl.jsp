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
<%@page import="com.fifth.bean.CustomerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.fifth.bean.MenusBean"%>
<%@page import="com.fifth.bean.FoodsBean"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
	<!-- checkout -->
	<div class="cart-items">
		<div class="container">
			<h1>我的购物车</h1>
					<%
						if (shoppingCartItemList != null) {
							for (ShoppingCartItemBean shoppingCartItemBean : shoppingCartItemList) {
								String food_booktime = shoppingCartItemBean
										.getFood_booktime();
								int food_count = shoppingCartItemBean.getFood_count();
								FoodsBiz foodsBiz=new FoodsBizImpl();
								FoodsBean foodsBean3=null;
								float total=0;
								int count=0;
									int shoppingCart_id=shoppingCartItemBean.getShoppingCart_id();
									int shoppingCartItem_id=shoppingCartItemBean.getShoppingCartItem_id();
									foodsBean3=foodsBiz.fetchFoodById(shoppingCartItemBean.getFood_id());
									String foods_Name = foodsBean3.getFood_name();
									String food_img = foodsBean3.getFood_img();
									double food_Price = foodsBean3.getFood_price();
									int food_Sale = foodsBean3.getFood_sale();
									int food_delivery_type = foodsBean3
											.getFood_delivery_type();
									double food_charge = foodsBean3.getFood_charge();
									
					%>
					
					<div class="acart">
					<div class="cart-header">
					<img class="close1" />
				       <div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						<img src="images/<%=food_img%>" class="img-responsive" alt="" height="90dp" width="125dp">
					</div>
					<div class="cart-item-info">
					
						<h3>
							<a href="#"><%=foods_Name%></a><span>预定时间:<%=food_booktime%></span>
						</h3>
						<ul class="qty">
							<li><p>
									单价:<span class="price"> <%=food_Price%></span>
									</p></li>
							<li>
						     <input type="hidden" value="<%=shoppingCartItem_id  %>"
								    name="shoppingCartItem_id" sciid="<%=shoppingCartItem_id  %>"
								     class="shoppingCartItemid"/>
							 <input type="hidden" value="<%=foodsBean3.getFood_id()%>"
								    name="food_id" fid="<%=foodsBean3.getFood_id()%>" class="foodid"/>
							 
							<p>
							数量:<input class="min" name="" type="button"
								value=" - " style="width:20px;" /> 
								<input class="text_box buynumber" name="buy_number" 
								type="text" style="width:20px;" readonly="readonly"
								value="<%=food_count%>" />
								<input class="add" name="" type="button" value="+" style="width:20px;" />
							</p>
							</li>
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
								总计: $<span class="fcount"><%=food_Price * food_count%></span> </p>
							<span>预计1-1:30小时送达</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				</div>
			</div>
		           <%
						}
							
					}else{
					%>
					购物车为空<br/><a href="./ResturantsServlet">请先预定食物</a>
					<%
					}
					%>

			<a 
				href="./findAllShoppingCartItem?temp_order=1">去下单</a>
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
	<script type="text/javascript">
	 $(".close1").click(
			function() {
				sciid=$(this).parent().find(".shoppingCartItemid").attr("sciid");
				total = $("#simpleCart_total").html();
				count = $("#simpleCart_quantity").html();
				num = parseInt($(this).parent().find(".text_box").val());
				fcount=parseInt($(this).parent().find(".fcount").html());
				total = parseFloat(total) -fcount ;
				count = parseInt(count) - num;
				
				$("#simpleCart_total").html("" + total);
				$("#simpleCart_quantity").html("" + count);
				$(this).parent().fadeOut('slow', function() {
			    $(this).parent().remove();
			    $.post('./UpdateShoppingCard',{shoppingCartItem_id:sciid},function(data){
					if(data=='1'){
					}
				});
		});
	});
	
	$(".add").click(
			function() {
				num = parseInt($(this).parent().find(".text_box").val());
				singleprice = $(this).parent().parent().parent().find(".price").html();
				singleprice = parseFloat(singleprice);
				sciid=$(this).parent().parent().find(".shoppingCartItemid").attr("sciid");
				fcount=parseInt($(this).parent().parent().parent().parent().find(".fcount").html());
				num = num + 1;
				$(this).parent().find(".text_box").val(num);
				total = $("#simpleCart_total").html();
				count = $("#simpleCart_quantity").html();
				total = parseFloat(total) + singleprice;
				count = parseInt(count) + 1;
				fcount=num*singleprice;
				$("#simpleCart_total").html("" + total);
				$("#simpleCart_quantity").html("" + count);
				$(this).parent().parent().parent().parent().find(".fcount").html("" + fcount)
				$.post('./UpdateShoppingCard',{buy_number:num,shoppingCartItem_id:sciid},function(data){
					if(data=='1'){
					}
				});
			});
	$(".min").click(function() {

		num = parseInt($(this).parent().find(".text_box").val());
		if (num != 1) {
			singleprice = $(this).parent().parent().parent().find(".price").html();
			singleprice = parseFloat(singleprice);
			sciid=$(this).parent().parent().find(".shoppingCartItemid").attr("sciid");
			fcount=parseInt($(this).parent().parent().parent().parent().find(".fcount").html());
			num = num - 1;
			$(this).parent().find(".text_box").val(num);
			total = $("#simpleCart_total").html();
			count = $("#simpleCart_quantity").html();
			total = parseFloat(total) - singleprice;
			count = parseInt(count) - 1;
			fcount=num*singleprice;
			$("#simpleCart_total").html("" + total);
			$("#simpleCart_quantity").html("" + count);
			$(this).parent().parent().parent().parent().find(".fcount").html("" + fcount)
			$.post('./UpdateShoppingCard',{buy_number:num,shoppingCartItem_id:sciid},function(data){
				if(data=='1'){
				}
			});
		}

	});
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
			$(this).parentsUntil().find('.cart-header').fadeOut('slow', function() {
				    $(this).parentsUntil().find('.cart-header').remove();
			});
			});
	
</script>	
</body>
</html>